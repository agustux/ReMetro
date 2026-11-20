# AGENTS.md

Guidance for coding agents working in this repository.

## Project Shape

- ReMetro: offline, FOSS Android music player, forked from Retro Music Player. XML layouts, Fragments, ViewBinding, Material Components, Navigation/Safe Args. Not Compose.
- Modules: `:app` and `:appthemehelper`.
- Package/namespace: `io.github.agustux.remetro` (app), `io.github.agustux.remetro.appthemehelper` (theme helper). App code lives under `app/src/main/java/io/github/agustux/remetro`.
- Single variant: no product flavors. Source sets are `main` and `debug`.
- Use the checked-in Gradle wrapper from the repository root, Java 21.

## Offline Only

- No network code, no `INTERNET` permission, no Google/Play/Cast/Firebase/billing libraries. Do not add them, and do not add online features (streaming, downloading, Last.fm/Deezer, online lyrics, update checks, analytics).
- Local music only.
- Strings are English only: edit `values/strings.xml`; do not add `values-<locale>` directories or a language picker.

## Build And Verification

- `./gradlew lint`
- `./gradlew :app:assembleDebug`
- `./gradlew assembleRelease` (R8 enabled; run when touching proguard rules, reflection, Glide, Room or Koin).
- Release signing is optional: put `storeFile`, `keyAlias`, `storePassword`, `keyPassword` in an untracked `signing.properties`; without it the debug key is used.
- CI (`.github/workflows/android.yml`) runs `./gradlew lint` and `./gradlew app:assemble`, uploading `app/build/outputs/apk/release/*.apk`.
- No substantial test suite; do not add broad test scaffolding for a narrow fix.

## Architecture Rules

- `App.kt` owns app startup, Koin startup, crash handling, shortcuts, wallpaper accent setup and default preferences.
- `MainModule.kt` is the DI map. Register new repositories, services and ViewModels there.
- `Repository` / `RealRepository` is the data facade. Prefer repository/ViewModel changes over direct data access from fragments or adapters.
- Room: `ReMetroDatabase` and DAOs/entities under `db/`. Schema change requires a real migration wired into `Room.databaseBuilder(...).addMigrations(...)`. Keep entity and table names stable.
- MediaStore, Room, tag editing, backup/restore, image decoding and playlist operations stay off the main thread (`viewModelScope`, lifecycle scopes, `Dispatchers.IO`).
- Avoid unowned background work from adapters, dialogs or menu helpers.
- Keep UI state in ViewModels; fragments coordinate views, navigation and observers.

## Android UI Rules

- Match existing patterns; reuse base fragments, adapters, dialogs, extensions and helpers.
- Keep `app/src/main/res/navigation/*.xml` in sync with fragment argument changes.
- User-visible strings go in resources; `donottranslate.xml` only for non-user-facing constants.
- Theming: `appthemehelper` plus Material attrs. Catppuccin colors live in `appthemehelper/src/main/res/values/colors_catppuccin.xml` (Mocha dark/black, Latte light); use them and theme attrs instead of hard-coded colors. Respect `values/styles*.xml`, dimens and night qualifiers.
- Do not introduce Jetpack Compose for isolated screens.

## Playback, Artwork, And Performance

- `MusicPlayerRemote`, `service/`, player fragments, widgets, Android Auto and notifications are hot paths. Never block them with disk, MediaStore, Room or artwork work.
- Use the existing Glide integration (`ReMetroGlideExtension`, `ReMetroGlideModule`) for album/artist art, palettes, widgets and notifications. Clear or replace long-lived Glide targets when updating widgets/notifications.
- Large libraries: avoid repeated full-list sorting/filtering on the main thread and decoding large artwork in render paths.

## Dependencies And Generated Files

- Versions live in `gradle/libs.versions.toml`. KSP is used for Room and Glide.
- Do not edit generated outputs, `.gradle/`, build folders, IDE metadata, or local/signing files.
- Never commit secrets: `signing.properties`, keystores, API keys.

## Change Hygiene

- Start with `git status --short`; preserve unrelated changes.
- Keep changes scoped; no broad rewrites, dependency upgrades or style-only churn unless requested.
- Match the surrounding Kotlin/Java style and resource organization.
- For significant features or refactors, follow `CONTRIBUTING.md` and confirm direction first.

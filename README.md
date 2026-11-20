# ReMetro

An offline, Google-free local music player for Android.

## Fork notice

ReMetro is a fork of [Retro Music Player](https://github.com/RetroMusicPlayer/RetroMusicPlayer) by Hemanth Savarla and contributors. It incorporates de-Google work from [Metro](https://github.com/MuntashirAkon/Metro). Licensed under GPLv3. ReMetro is not affiliated with or endorsed by the upstream authors.

Main differences from upstream:

- Fully offline: no `INTERNET` permission.
- No Google, Play Services, billing or Cast.
- No Last.fm, Deezer or online lyrics.
- No home header or profile.
- English only.
- Catppuccin theme (Mocha dark/black, Latte light).

## Build

Requires JDK 21.

```
./gradlew assembleRelease
```

Release signing is optional: create an untracked `signing.properties` with `storeFile`, `keyAlias`, `storePassword` and `keyPassword`. Without it the debug key is used.

## License

GPLv3, see [LICENSE.md](LICENSE.md).

## Credits

- [Retro Music Player](https://github.com/RetroMusicPlayer/RetroMusicPlayer) by Hemanth Savarla and contributors.
- [Metro](https://github.com/MuntashirAkon/Metro) by Muntashir Al-Islam.

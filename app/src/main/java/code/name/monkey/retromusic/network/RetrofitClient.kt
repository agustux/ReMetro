package code.name.monkey.retromusic.network

import android.content.Context
import code.name.monkey.retromusic.App
import code.name.monkey.retromusic.BuildConfig
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit


fun provideDefaultCache(): Cache? {
    val cacheDir = File(App.getContext().cacheDir.absolutePath, "/okhttp-lastfm/")
    if (cacheDir.mkdirs() || cacheDir.isDirectory) {
        return Cache(cacheDir, 1024 * 1024 * 10)
    }
    return null
}

fun logInterceptor(): Interceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    } else {
        // disable retrofit log on release
        loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
    }
    return loggingInterceptor
}

fun headerInterceptor(context: Context): Interceptor {
    return Interceptor {
        val original = it.request()
        val request = original.newBuilder()
            .header("User-Agent", context.packageName)
            .addHeader("Content-Type", "application/json; charset=utf-8")
            .method(original.method, original.body)
            .build()
        it.proceed(request)
    }
}

fun provideOkHttp(context: Context, cache: Cache): OkHttpClient {
    return OkHttpClient.Builder()
        .addNetworkInterceptor(logInterceptor())
        .addInterceptor(headerInterceptor(context))
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .cache(cache)
        .build()
}


# Movies App
A movie app demonstrating android development best practices using popular android libraries.
Note that the changes may not be backward compatible. You will need to uninstall and re-install the app if that happens.

## Setup
This app uses [TMDB database](https://developers.themoviedb.org/) to fetch movies details.

#### Getting TMDB API Key
To use the TMDB API, you will need to setup a free TMDB account and generate V3 API key. See [TMDB Documentation](https://developers.themoviedb.org/3/getting-started/introduction) for instructions.
Once you obtain the key, add it inside gradle.properties -> `TMDB_API_KEY=<your-tmdb-key>`

## Development Instructions
**Application is currently developed and tested on : Android Studio Arctic Fox | 2020.3.1**

If you use a lower version the app might not compile. For newer versions you will need to update the android-gradle-plugin version accordingly.

### Setting up Spotless pre-commit hook
Spotless is used to format code. To setup the spotless pre-commit hook, execute `./spotless/creat-spotless-pre-commit-hook.sh`

## Libraries Used
Some of the main libraries used in the app are -
* [Compose](https://developer.android.com/jetpack/compose) for UI.
* [Navigation](https://developer.android.com/guide/navigation) for all the in-app navigation.
* [Paging-3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) for pagination support.
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection.
* [Room](https://developer.android.com/training/data-storage/room)
* [Coroutines](https://developer.android.com/kotlin/coroutines) for async operations.
* [OkHttp && Retrofit](https://github.com/square/retrofit) for networking.
* [Coil](https://github.com/coil-kt/coil) for image loading.
* [Mockk](https://github.com/mockk/mockk) for mocking.
* [Robolectric](https://github.com/robolectric/robolectric) for unit testing of android components.
* [Truth](https://github.com/google/truth) for readable assertions.
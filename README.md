Movies App
==========
An movie app demonstrating android development best practices using popular android libraries.
Note that the changes may not be backward compatible. Please uninstall and re-install the app.

Setup
-----
This app uses [TMDB database](https://developers.themoviedb.org/) to fetch movies details.

#### Getting TMDB API Key
To use the TMDB API, you will need to setup a free TMDB account and generate V3 API key. See [TMDB Documentation](https://developers.themoviedb.org/3/getting-started/introduction) for instructions.

Development Instructions
------------------------
For development, usually latest beta version of Android Studio is required.
In case the latest beta version has some known issues, a version lower will be used instead.   

#### Setting up Spotless pre-commit hook
Spotless is used to format code. To setup the spotless pre-commit hook, execute `./spotless/creat-spotless-pre-commit-hook.sh`

Core Libraries Used
-------------------
#### Jetpack Libraries
* [Compose](https://developer.android.com/jetpack/compose) for UI.
* [Navigation](https://developer.android.com/guide/navigation) for all the in-app navigation
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection.

#### Third party libraries
* [Coroutines](https://developer.android.com/kotlin/coroutines) for async operations.
* [Retrofit](https://github.com/square/retrofit) for networking.
* [Mockk](https://github.com/mockk/mockk) for mocking.
* [Robolectric](https://github.com/robolectric/robolectric) for unit testing of android components.

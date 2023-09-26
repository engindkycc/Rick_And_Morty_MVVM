# Rick_And_Morty_MVVM
It is an application where the user can list Rick and Morty locations, characters in the location and view the details of the characters.

Link to the api : https://rickandmortyapi.com

## Project Screen
SPLASH SCREEN | HOME SCREEN | 
--- | ---|
![SplashScreen](https://github.com/engindkycc/Rick_And_Morty_MVVM/assets/95877203/7763ca56-0f3a-4938-885e-4041f9c99f6b)|![HomeScreen](https://github.com/engindkycc/Rick_And_Morty_MVVM/assets/95877203/cf962300-ac84-4f6b-9cad-6f7b26ec37c8)

DETAİL SCREEN |
--- | 
|![DetailScreen](https://github.com/engindkycc/Rick_And_Morty_MVVM/assets/95877203/bf35177a-c0fb-4a68-b829-ba79d212b3e2)|

### Technology / Others
- This app made %100 with  [Kotlin](https://developer.android.com/kotlin)
- [Navigation Componenet](https://developer.android.com/guide/navigation):Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) : The ViewModel class is a business logic or screen level state holder. It exposes state to the UI and encapsulates related business logic. Its principal advantage is that it caches state and persists it through configuration changes. This means that your UI doesn’t have to fetch data again when navigating between activities, or following configuration changes, such as when rotating the screen.
- [Livedata](https://developer.android.com/topic/libraries/architecture/livedata) : LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.
- [MVVM ](https://en.wikipedia.org/wiki/Model–view–viewmodel): Model–view–viewmodel (MVVM) is an architectural pattern in computer software that facilitates the separation of the development of the graphical user interface (GUI; the view)—be it via a markup language or GUI code—from the development of the business logic or back-end logic (the model) such that the view is not dependent upon any specific model platform.
- [Fragments ](https://developer.android.com/guide/fragments): A Fragment represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events. Fragments can't live on their own. They must be hosted by an activity or another fragment. The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy.
- [Glide ](https://github.com/bumptech/glide) : A library for imageView. Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.
- [Paging 3](https://proandroiddev.com/paging-3-easier-way-to-pagination-part-1-584cad1f4f61) : Most apps display a large list of data, however, users generally see only a small part of it, so fetching all of the list data from the network is not an optimum solution.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) : Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project. Doing manual dependency injection requires you to construct every class and its dependencies by hand, and to use containers to reuse and manage dependencies.


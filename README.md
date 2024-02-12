# Pexels-Application (Test Task)

## Description
I was tasked with creating an application similar to Pinterest based on the [Pexels API](https://www.pexels.com/api/documentation/), where users can view collections of images and select their favorites.

## Required Technology Stack (Jetpack Compose)
1. Single Activity, Clean Architecture, MVVM
2. Dagger2/Hilt
3. Retrofit
4. Coroutines+Flow
5. Room
6. Coil

## Work Done
### Preparation for Application Development
This was the first fairly serious application I had to create. Therefore, when I read the required technology stack, I didn't understand anything :) But I didn't have much time to study the theory anyway. I decided to start with practice right away and made something similar to the [bookshelf](https://github.com/nafaniaa/Bookshelf) application based on [video tutorials](https://www.youtube.com/watch?v=V9KaAfywQvw&t=1s). This way, I learned what MVVM is, Clean Architecture, and how to work with Retrofit. I approached the rest of the required technologies in the same way.

## Application Development
During the application development, I started over three times. The first time was purely due to lack of experience. I tried to follow the code of another application, thinking that later I would be able to adapt it to what I needed. At the same time, I poorly understood what I was writing. Big mistake. I spent too much time on it. Finally, I decided to start from scratch. Here is the [link](https://github.com/nafaniaa/PexelsApp) to that repository. However, there were still some problems. When I tried to run the draft application on my phone, I kept getting the same error:

 > caused by: org.gradle.api.internal.artifacts.ivyservice.defaultlenientconfiguration$artifactresolveexception: could not resolve all files for configuration ':app:debugruntimeclasspath'.

I spent a long time on this. I searched all the websites, but nothing helped. So, if you're reading this, maybe you can tell me, if it's not too much trouble, what exactly the error was. I assume the problem was with the dependencies, because when I redid everything for the third time, everything started up fine.

Now, let's talk about the last attempt. Even I managed to start something, but the images still didn't start loading. Most likely, there was an issue with creating the database, because I tested the Retrofit functionality many times.

![image](https://github.com/nafaniaa/Pexels-Application/assets/72029335/85d853b3-a035-4f0e-a348-d1aa69c509b2)

However, when I open the App Inspector, the database is not displayed. And then I redid it, and now when I launch the application, it crashes :)

## Project Structure
- **app**: Contains the main application code.
  - `src/main/java/com/example/pexelsapplication`: Main package for application code.
    - `PexelsApplication.kt`: Application class.
    - `ui`: Package for UI-related components.
      - `screens`: Package for different screens of the application.
        - `HomeScreen.kt`: Composable function for the home screen.
        - `LoadingScreen.kt`: Composable function for the loading screen.
        - `NetworkStubScreen.kt`: Composable function for the network stub screen.
        - `GridPhotosScreen.kt`: Composable function for displaying a grid of photos.
        - `PexelsPhotoApp.kt`: Composable function representing the entire application.
        - `EmptyBookmarksScreenTextAndButton.kt`: Composable function for displaying empty bookmarks screen text and button.
        - `EmptyDetailsScreenTextAndButton.kt`: Composable function for displaying empty details screen text and button.
        - `EmptyHomeScreenTextAndButton.kt`: Composable function for displaying empty home screen text and button.
      - `viewmodels`: Package for view model classes.
        - `PhotosViewModels.kt`: ViewModel for managing photo data and UI state.
    - `data`: Package for data-related components.
      - `entities`: Package for database entity classes.
        - `PexelsPhotoEntity.kt`: Entity class representing a photo in the database.
      - `enums`: Package for enum classes.
        - `PexelsSize.kt`: Enum class representing different sizes of images on Pexels.
      - `repositories`: Package for repository classes.
        - `PexelsPhotoRepository.kt`: Repository class for fetching photos from the Pexels API.
      - `dao`: Package for DAO (Data Access Object) classes.
        - `PexelsPhotoDao.kt`: DAO interface for photo-related database operations.
      - `database`: Package for database-related components.
        - `PexelsPhotoDatabase.kt`: Database class using Room for storing photos.
    - `network`: Package for network-related components.
      - `PexelsApi.kt`: Interface for defining API endpoints.
      - `PexelsApiClient.kt`: Class for making API requests using Retrofit and OkHttpClient.
      - `PexelsResponse.kt`: Data class representing the response from the Pexels API.
    - `PexelsAppContainerImpl.kt`: Class implementing dependency injection container for the application.
- **res**: Contains resources such as layouts, strings, and drawables.
- **build.gradle**: Gradle build configuration file for the entire project.
- **README.md**: Markdown file containing project overview and structure.

 ## Screenshots
 Unfortunately, a lot of things, as mentioned earlier, I can't run to take a screenshot.
 
EmptyBookmarksScreen.kt
 
 ![image](https://github.com/nafaniaa/Pexels-Application/assets/72029335/68e9dc34-0328-4e60-a8e0-a5e8d282f45a)

EmptyDetailsScreen.kt

 ![image](https://github.com/nafaniaa/Pexels-Application/assets/72029335/a3395b81-69fa-4671-8ae2-ea085996f8c5)

EmptyHomeScreen.kt
 
 ![image](https://github.com/nafaniaa/Pexels-Application/assets/72029335/7526f959-90d6-4ed5-ab0a-fbc9c9ae6708)

NetworkStubScreen.kt
 
 ![image](https://github.com/nafaniaa/Pexels-Application/assets/72029335/b5634741-b4a9-4892-bf10-a40ddfafa2de)




  

## Conclusion
I think it makes sense to summarize the work done.
1. Now I know exactly what I need to learn.
2. I understand why application architecture is needed. Before, I only encountered MVC in university, and even then only a little. (And I didn't understand why it was needed)
3. I need someone I can ask something, teamwork.
4. I need to improve my English language skills. Because, unfortunately, there are not so many sources of information in the Russian-speaking Internet.
5. I definitely like android development.

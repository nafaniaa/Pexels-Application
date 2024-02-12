# Pexels-Application (Тестовое задание)
 ## Описание
 Передо мной стояла задача сделать приложение похожее на Pinterest на базе [Pixel Api](https://www.pexels.com/api/documentation/), в котором пользователь сможет смотреть подборки картинок и выбирать понравившиеся.
 ## Требуемый стек технологий (Jetpack Compose)
1. Single Activity, Clean Architecture, MVVM
2. Dagger2/Hilt
3. Retrofit
4. Coroutines+Flow
5. Room
6. Coil
 ## Проделанная работы
 ### Подготовка к созданию приложения
Это было первое достаточно серьезное приложение, которое мне надо было сделать. Поэтому, когда я прочитала требуемый стек технологий, я ничего не поняла :) Но и времени на изучение теории у меня особо не было. Я решила сразу начать с практики и сделала что-то похожее на приложение [книжная полка](https://github.com/nafaniaa/Bookshelf) по [видеоурокам](https://www.youtube.com/watch?v=V9KaAfywQvw&t=1s).Так я узнала, что такое MVVM, Clean Architecture и как работать с Retrofit. С остальными требуемыми технологиями я поступила так же.
 ## Разработка приложения
В процессе создания приложения я 3 раза начинала сначала. В первый раз это было сугубо по собственной глупости. Я пыталась делать по примеру кода другого приложения, думая, что потом я смогу подвязать это под то, что мне нужно. При этом я плохо понимала, что пишу. Ошибка. Потратила на это слишком много времени. Сделав выводы, я решила начать с самого начала. Вот [ссылка](https://github.com/nafaniaa/PexelsApp) на этот репозиторий. Однако и тут не без проблем. Когда я решила запустить набросок приложения на телефоне, мне выдавало одну и ту же ошибку:
 > caused by: org.gradle.api.internal.artifacts.ivyservice.defaultlenientconfiguration$artifactresolveexception: could not resolve all files for configuration ':app:debugruntimeclasspath'.

Тут я очень долго сидела. Облазила все сайты и ничего не помогло. Поэтому если вы это читаете, может, вы сможете, если вам не сложно, сказать мне, в чём конкретно была ошибка. Предполагаю, что проблема была в зависимостях, ибо когда переделывала всё в третий раз, всё нормально запустилось.

Ну и теперь про последнюю попытку. Тут даже я смогла что-то запустить, однако картинки так и не начали прогружаться. Скорее всего проблема с созданием базы данных, так как работу с Retrofit проверяла очень много раз.
 
 ![image](https://github.com/nafaniaa/Pexels-Application/assets/72029335/85d853b3-a035-4f0e-a348-d1aa69c509b2)
 
Однако когда открываю App Inspector, база данных не отображается. А потом я переделала, и теперь при запуске приложения происходит сбой :)


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

 ## Вывод
 Думаю имеет смысл подвести какой-то итог по проделанной работе.
 1. Теперь я точно знаю, что конкретно мне надо учить.
 2. Я поняла для чего нужна архитектура приложения. До этого в университете я сталкивалась только с MVC, и то совсем немного. (Да и я не понимала зачем это надо)
 3. Мне нужен кто-то, у кого я могу что-то спросить, работа в команде
 4. Нужно повышать уровень английского языка. Потому что, к сожалению, на просторах русскоязычного интернета источников с информацией не так много.
 5. Мне точно нравится android разработка.

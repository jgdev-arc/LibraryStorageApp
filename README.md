<h1 align = "center">
:books: <b><i>The Library App</i></b> :books:
</h1>
<br />

The Library Application is a simple Android application written in Kotlin using Jetpack Compose that serves as an example of how to implement the MVVM architecture and ROOM database in an Android app. This app allows users to interact with a collection of books in a database. You can insert new books, edit their information, and delete them. 
My main goal with this application was to become more familiar with these key Android development concepts. 

<p align="center">
  <img src="https://github.com/jgdev-arc/LibraryStorageApp/blob/master/main.gif" alt="walkthrough">
</p>

# :camera_flash: **Features** :camera_flash:

- **MVVM Architecture:** The Library Application follows the Model-View-ViewModel (MVVM) architectural pattern. This separation of concerns ensures that the codebase is organized and maintainable.

- **ROOM Database:** The app utilizes the ROOM database library, a top-level abstraction over SQLite databases in Android. This choice allows for a smooth interaction with the database while providing a consistent and efficient way to store and retrieve data.

- **Basic UI:** The user interface intentionally maintains a basic design to focus on demonstrating the MVVM and ROOM database implementation. The primary goal is to showcase how data is handled and managed in a lifecycle-conscious manner, rather than creating a complex user interface.

- **Persistent Data:** All data in The Library Application is persistent, which means that the user's book collection remains intact even when the app is closed or the device is restarted.

- **ViewModel:** The app employs a ViewModel to hold the app's UI data in a lifecycle-conscious way. This ensures that data survives configuration changes, such as screen rotations, without the need for complicated data reloading processes.

- **Separation of Concerns:** The Library Application maintains a clear separation of concerns. Activities and fragments are responsible for rendering data to the screen, while the ViewModel is responsible for holding and processing all the data needed for the UI. This approach adheres to the single responsibility principle and makes the codebase more maintainable.

<p align="center">
  <img src="https://github.com/jgdev-arc/LibraryStorageApp/blob/master/1.png" alt="mvvm">
</p>

## :hammer_and_wrench: Usage :hammer_and_wrench:

- Adding a Book: You can add a new book to the database by selecting the "Insert Book Into Database" option and filling out the required information.
- Editing a Book: To edit the information of an existing book, select the book you want to edit and make the necessary changes.
- Deleting a Book: To remove a book from the database, simply tap the trash icon next to the book you want to delete.

# :arrow_lower_right: Deployment :arrow_lower_right:
These are the key parameters for DiaryApp.

| Parameters     | Value |
|----------------|-------|
| compileSdk     | 34    |
| targetSdk      | 33    |
| minSdk         | 24    |
| composeVersion | 1.4.0 |
| kotlinVersion  | 1.8.0 |

You can clone the repository or download the Zip file [here](https://github.com/jgdev-arc/LibraryStorageApp).

To build and run the app, you will need the latest version of Android Studio Flamingo (or [newer](https://developer.android.com/studio/)) installed on your system.



# :building_construction: Tech Stack :building_construction:

The Library Storage App uses many popular libraries and tools in the Android Ecosystem:

* [Jetpack Compose](https://developer.android.com/jetpack/compose) - modern toolkit for building native Android UI.
* [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) - navigate between composables while taking advantage of the stateful NavController which keeps track of the back stack of composables that make up the screens in your app. 
* [Room](https://developer.android.com/topic/libraries/architecture/room) persistence library which provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.


# :memo: Authors :memo:
- [@jgdev-arc](https://github.com/jgdev-arc)
  
Do Reach Out :

  * [Twitter](https://twitter.com/jon_g_dev)


# :scroll: License :scroll:

MIT License

Copyright (c) [2023] [jgdev-arc]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

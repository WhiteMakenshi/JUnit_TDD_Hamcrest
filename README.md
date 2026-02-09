## Descripción del Proyecto: Auth

Este es un proyecto de aplicación para Android llamado **Auth**. Su propósito principal es gestionar la autenticación de usuarios. La aplicación está desarrollada utilizando Kotlin y sigue las prácticas modernas de desarrollo de Android.

### Estructura del Proyecto

El proyecto tiene una estructura estándar de Android Studio, organizada de la siguiente manera:

-   **/app**: El módulo principal de la aplicación.
    -   `src/main`: Contiene el código fuente de la aplicación (`MainActivity.kt`), los recursos y el `AndroidManifest.xml`.
    -   `src/test`: Destinado a las pruebas unitarias.
    -   `src/androidTest`: Para las pruebas de instrumentación.
-   **/gradle**: Contiene los scripts y el wrapper de Gradle.
-   `build.gradle.kts`: El archivo de configuración de compilación para el proyecto y el módulo `app`, utilizando Kotlin DSL.

### Funcionalidad Principal

La `MainActivity` gestiona la lógica de la interfaz de usuario para la autenticación.

1.  **Inicio de Sesión (Login)**:
    -   La interfaz de usuario inicial (`containerAuth`) muestra campos para el correo electrónico y la contraseña.
    -   Al hacer clic en el botón "Login", se invoca la función `login()`.
    -   Esta función oculta el teclado y llama a `userAuthentication()` (lógica no implementada en este archivo) para validar las credenciales.
    -   Si la autenticación es exitosa, se llama a `changeUIAuth()`.

2.  **Transición de UI**:
    -   La función `changeUIAuth()` utiliza una transición `MaterialFadeThrough` para animar el cambio de visibilidad entre dos contenedores.
    -   Oculta la vista de autenticación (`containerAuth`) y muestra la vista principal de la aplicación (`containerMain`).

3.  **Cierre de Sesión (Sign Out)**:
    -   Un botón "Sign Out" en la vista principal (`containerMain`) permite al usuario cerrar la sesión.
    -   La función `signOut()` realiza la transición inversa, ocultando el contenido principal y volviendo a mostrar la pantalla de autenticación.

### Características Técnicas

-   **Lenguaje**: Kotlin
-   **Arquitectura de UI**: Uso de View Binding (`ActivityMainBinding`) para una interacción segura y eficiente con las vistas del layout.
-   **Componentes de Material Design**:
    -   Utiliza componentes de la librería `com.google.android.material`.
    -   Implementa `MaterialFadeThrough` para transiciones de UI fluidas y modernas.
-   **Dependencias Clave**:
    -   `androidx.appcompat:appcompat`
    -   `com.google.android.material:material`
    -   `androidx.constraintlayout:constraintlayout`

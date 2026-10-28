# Guía de inicio - Proyecto Denuncias (API + App Android)

## Requisitos previos

- **JDK 21** (se puede usar el JBR incluido en Android Studio):
  - `C:\Program Files\Android\Android Studio\jbr`
- **Android Studio** con emulador Android (recomendado).
- **Gradle Wrapper** (incluido en ambos proyectos).

## 1. Ejecutar la API (Spring Boot)

Abrir PowerShell y ejecutar:

```powershell
$env:JAVA_HOME="C:\Program Files\Android\Android Studio\jbr"
$env:Path="$env:JAVA_HOME\bin;$env:Path"
cd C:\Users\ADMINIST\Desktop\manuelito\examen\examen_api
.\gradlew.bat bootRun --offline
```

La API quedará disponible en:

- `http://localhost:8080`
- Consola H2: `http://localhost:8080/h2-console`

Verificar que responde:

```powershell
Invoke-RestMethod -Uri "http://localhost:8080/denuncias/" -Method Get
```

## 2. Ejecutar la App Android (front)

1. Abrir `examen_frond` en Android Studio.
2. Sincronizar Gradle.
3. Ejecutar en un **emulador de Android Studio** (la URL base es `http://10.0.2.2:8080/`).

> Nota:
> - Si usas Genymotion, cambia la URL base en `ApiClient.kt` a `http://10.0.3.2:8080/`.
> - Si usas dispositivo físico, cambia la URL base a la IP real del PC (ej. `http://192.168.x.x:8080/`) y asegúrate de estar en la misma red.

## 3. Problemas comunes

- **"Failed to connect 10.0.2.2:8080"**: la API no está corriendo o el emulador no es el de Android Studio.
- **Firewall de Windows**: permite el puerto 8080 para Java/Gradle.
- **Puerto ocupado**: cambia `server.port` en `application.properties` y actualiza la URL base del front.

## 4. Configuración relevante

- API: `examen_api/src/main/resources/application.properties`
- Front URL base: `examen_frond/app/src/main/java/com/fernandez/denunciasapp/data/network/ApiClient.kt`
- Permisos de red (cleartext): `examen_frond/app/src/main/AndroidManifest.xml`
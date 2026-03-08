🛠️ Requisitos del Sistema
HerramientaVersión recomendadaJava JDK8 o superiorXAMPP8.x (incluye MySQL 8.x)IDENetBeans / IntelliJ / Eclipse

📥 Dependencias Externas (Descarga Manual)
1. 🗄️ XAMPP — Servidor de Base de Datos (MySQL)
XAMPP es el entorno local que provee el servidor MySQL necesario para este proyecto.

🔗 Descarga oficial: https://www.apachefriends.org/es/download.html
Versión usada en el proyecto: XAMPP 8.x con MySQL 8.x
Instrucciones:

Descargar e instalar XAMPP.
Abrir el Panel de Control de XAMPP y iniciar el módulo MySQL.
Importar el archivo .sql incluido en la carpeta /database del proyecto (si aplica).




2. 🔌 MySQL Connector/J — Conector JDBC para MySQL
Permite la conexión entre la aplicación Java y la base de datos MySQL.

🔗 Descarga oficial: https://dev.mysql.com/downloads/connector/j/
Archivo requerido: mysql-connector-j-8.0.33.jar
Descarga directa (Maven Central): mysql-connector-j-8.0.33.jar
Instrucciones:

Descargar el archivo .jar.
En tu IDE, agregar el .jar al classpath/build path del proyecto:

NetBeans: Click derecho en el proyecto → Properties → Libraries → Add JAR/Folder
IntelliJ: File → Project Structure → Modules → Dependencies → + → JARs
Eclipse: Click derecho en el proyecto → Build Path → Add External Archives


3. 📄 iTextPDF — Generación de Archivos PDF
Librería para generar documentos PDF desde Java.

🔗 Descarga oficial: https://github.com/itext/itextpdf/releases/tag/5.5.13
Archivo requerido: itextpdf-5.5.13.jar
Descarga directa (Maven Central): itextpdf-5.5.13.jar
Instrucciones:

Descargar el archivo .jar.
Agregarlo al classpath del proyecto (mismo proceso que el conector MySQL).


Licencia: AGPL / Versión comercial disponible.


4. 📊 JFreeChart — Generación de Gráficas y Charts
Librería para crear gráficas (barras, tortas, líneas, etc.) en aplicaciones Java.

🔗 Descarga oficial: https://sourceforge.net/projects/jfreechart/files/1.%20JFreeChart/1.5.3/
Archivo requerido: jfreechart-1.5.3.jar
Descarga directa (Maven Central): jfreechart-1.5.3.jar
Instrucciones:

Descargar el archivo .jar.
Agregarlo al classpath del proyecto.


Nota: JFreeChart también requiere la librería jcommon. Si se presentan errores, descarga también:

jcommon-1.0.24.jar


⚙️ Configuración de Base de Datos

Asegúrate de que XAMPP esté corriendo con MySQL activo.
Abre phpMyAdmin en http://localhost/phpmyadmin.
Crea una base de datos con el nombre especificado en el archivo de configuración del proyecto.
Importa el script SQL si está disponible en la carpeta /database.
Verifica las credenciales de conexión en el código fuente (usuario, contraseña, host, puerto).

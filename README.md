
# 🎵 SpotyWeb

## Autori
Sophia Deroma, Silano Davide, Tommaso Spano, Federico Zummo

---

## 📌 Descrizione e obiettivi del progetto

SpotyWeb è un'applicazione web Java sviluppata come progetto Maven. Il suo scopo è:

- Permettere la **ricerca di canzoni** tramite le **API di Spotify**.
- Consentire all’utente di **salvare le canzoni trovate** nel **database MariaDB locale**, aggiungendo anche un **commento**.

Il progetto si basa su un’interfaccia web semplice e l’interazione avviene tramite form e servlet.

---

## 🚀 Istruzioni su come usare il progetto

### ✅ Requisiti

- **Java JDK** (versione 8 o superiore)
- **Apache Maven**
- **MariaDB** (tramite XAMPP o installazione locale)
- **Eclipse IDE**
- Plugin Maven `jetty-maven-plugin` configurato nel `pom.xml`

### 🧪 Setup e avvio

1. Avvia **XAMPP** e attiva **MySQL**.
2. Importa il file SQL (database `Spotyweb`) tramite **PhpMyAdmin**.
3. Apri il progetto in **Eclipse** come **Maven Project**.
4. Esegui il progetto con Maven:

   ```bash
   mvn jetty:run
   ```

5. Vai su <http://localhost:8080>

### 🕹️ Come si usa

- Inserisci il **nome della canzone** nel campo di ricerca.
- Visualizza l’elenco delle 10 canzoni trovate.
- Seleziona una canzone tramite il suo indice.
- Inserisci **nome utente** e **commento** nei campi appositi.
- Premi il pulsante **"Carica"** per salvare la canzone e il commento nel database.

---

## 🧱 Scelte architetturali e motivazioni

- **Jetty** è stato scelto come web server per la sua leggerezza e facilità di integrazione con Maven.
- Le **API REST di Spotify** forniscono un'interfaccia potente e gratuita per la ricerca musicale.
- **MariaDB** è stato preferito per semplicità, integrazione con JDBC e compatibilità con XAMPP.
- Pattern utilizzato: **MVC** (Model-View-Controller), con JSP per la parte view.

---

## 🧩 Scomposizione in servizi e loro ruolo

- `SpotifyService.java`: comunica con le API di Spotify e restituisce i risultati.
- `SearchServlet.java`: riceve la parola chiave, invoca SpotifyService, e invia i dati alla view.
- `CommentServlet.java`: riceve il commento utente e salva le informazioni nel database.
- `DatabaseManager.java`: classe di utilità per connettersi al DB e eseguire operazioni SQL.
- `SongComment.java`: modello che rappresenta una canzone con commento.
- `index.jsp` / `result.jsp`: interfacce utente per la ricerca e l'invio dei commenti.

---

## 🧠 Architettura dei servizi e implementazione

### Struttura logica

- **Model**: `SongComment.java`, `DatabaseManager.java`
- **Controller**: `SearchServlet.java`, `CommentServlet.java`
- **View**: `index.jsp`, `result.jsp`

### Flusso

1. Utente accede alla pagina e cerca una canzone.
2. La richiesta è gestita da `SearchServlet`.
3. I risultati sono ottenuti tramite `SpotifyService`.
4. L’utente seleziona una canzone, inserisce un commento e invia.
5. `CommentServlet` gestisce l'invio e salva i dati tramite `DatabaseManager`.

---

## 📉 Limitazioni o problemi riscontrati

- Non è stata implementata la **visualizzazione dei dati salvati** nella pagina web.
- I dati sono comunque salvati correttamente nella tabella `commenti` e visibili tramite **PhpMyAdmin**.

---

## 📂 Struttura del progetto

```
SpotyWeb/
├── src/
│   └── main/
│       ├── java/
│       │   └── com.spotyweb/
│       │       ├── db/DatabaseManager.java
│       │       ├── model/SongComment.java
│       │       ├── service/SpotifyService.java
│       │       └── servlet/
│       │           ├── SearchServlet.java
│       │           └── CommentServlet.java
│       └── webapp/
│           ├── index.jsp
│           ├── result.jsp
│           └── WEB-INF/web.xml
├── pom.xml
└── README.md
```

---

## 🗃️ Database (MariaDB)

Nome del database: `Spotyweb`

Esempio di struttura tabella `commenti`:

```sql
CREATE TABLE commenti (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  artist VARCHAR(255),
  comment TEXT
);
```

---

## 🔚 Licenza

Progetto scolastico realizzato per fini didattici. Tutti i diritti riservati ai rispettivi autori.

---

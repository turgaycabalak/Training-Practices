

const form = document.getElementById("film-form")
const titleElement = document.querySelector("#title")
const directorElement = document.querySelector("#director")
const urlElement = document.querySelector("#url")
const cardBody = document.querySelectorAll(".card-body")[1]
const clearAll = document.getElementById("clear-films")

// UI Objesini Baslatma (initialize etmek)
const ui = new UI()

// Storage Objesi
const storage = new Storage()


// Tum eventleri yukleme
evetListeners()


function evetListeners() {
    form.addEventListener("submit", addFilm)
    document.addEventListener("DOMContentLoaded", loadAllFilmsToUI)
    cardBody.addEventListener("click", deleteFilm)
    clearAll.addEventListener("click", deleteAllFilms)
}


function deleteAllFilms() {
    if (confirm("Tumunu silmek istediginize emin misiniz?")) {
        // ui elementlerini sil
        ui.deleteAllFilmsFromUI()
        // storage'dan tumunu sil
        storage.deleteAllFilmsFromStorage()
        // displayMessage
        ui.displayMessages("Tum filmler basariyla silindi...", "success")
    }
}

function deleteFilm(e) {
    if (e.target.id === "delete-film") {
        // ui elementi sil
        ui.deleteFilmFromUI(e.target)
        // storage'dan sil
        storage.deleteFilmFromStorage(e.target.parentElement.previousElementSibling.previousElementSibling.textContent)
        // displayMessage
        ui.displayMessages("Film basarili sekilde silindi...", "success")
    }
}

function loadAllFilmsToUI() {
    const films = storage.getFilmsFromStorage()
    films.forEach(film => ui.addFilmToUI(film))
}

function addFilm(e) {
    const title = titleElement.value.trim()
    const director = directorElement.value.trim()
    const url = urlElement.value.trim()

    if (title === "" || director === "" || url === "") {
        // hata
        ui.displayMessages("Tum alanlari doldurun!", "danger")
    }
    else {
        const newFilm = new Film(title, director, url) // yeni film
        ui.addFilmToUI(newFilm) // arayuze film ekleme
        storage.addFilmToStorage(newFilm)// storage'a ekleme
        ui.displayMessages("Film basariyla eklendi...", "success")
    }

    ui.clearInputs(titleElement, urlElement, directorElement)

    e.preventDefault()
}
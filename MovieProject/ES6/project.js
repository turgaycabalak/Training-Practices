

const form = document.getElementById("film-form")
const titleElement = document.querySelector("#title")
const directorElement = document.querySelector("#director")
const urlElement = document.querySelector("#url")
const cardBody = document.querySelectorAll(".card-body")[1]
const clearAll = document.getElementById("clear-films")




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
        UI.deleteAllFilmsFromUI()
        // storage'dan tumunu sil
        Storage.deleteAllFilmsFromStorage()
        // displayMessage
        UI.displayMessages("Tum filmler basariyla silindi...", "success")
    }
}

function deleteFilm(e) {
    if (e.target.id === "delete-film") {
        // ui elementi sil
        UI.deleteFilmFromUI(e.target)
        // storage'dan sil
        Storage.deleteFilmFromStorage(e.target.parentElement.previousElementSibling.previousElementSibling.textContent)
        // displayMessage
        UI.displayMessages("Film basarili sekilde silindi...", "success")
    }
}

function loadAllFilmsToUI() {
    const films = Storage.getFilmsFromStorage()
    films.forEach(film => UI.addFilmToUI(film))
}

function addFilm(e) {
    const title = titleElement.value.trim()
    const director = directorElement.value.trim()
    const url = urlElement.value.trim()

    if (title === "" || director === "" || url === "") {
        // hata
        UI.displayMessages("Tum alanlari doldurun!", "danger")
    }
    else {
        const newFilm = new Film(title, director, url) // yeni film
        UI.addFilmToUI(newFilm) // arayuze film ekleme
        Storage.addFilmToStorage(newFilm)// storage'a ekleme
        UI.displayMessages("Film basariyla eklendi...", "success")
    }

    UI.clearInputs(titleElement, urlElement, directorElement)

    e.preventDefault()
}


function Storage() {

}

Storage.prototype.addFilmToStorage = function (newFilm) {
    let films = this.getFilmsFromStorage()
    films.push(newFilm)
    localStorage.setItem("films", JSON.stringify(films))
}

Storage.prototype.getFilmsFromStorage = function () {
    if (localStorage.getItem("films") === null) {
        return []
    }
    else {
        return JSON.parse(localStorage.getItem("films"))
    }
}

Storage.prototype.deleteFilmFromStorage = function (filmTitle) {
    let films = this.getFilmsFromStorage()
    films.forEach((film, index) => {
        if (film.title === filmTitle) {
            films.splice(index, 1)
        }
    })
    localStorage.setItem("films", JSON.stringify(films))
}

Storage.prototype.deleteAllFilmsFromStorage = function () {
    localStorage.removeItem("films")
}
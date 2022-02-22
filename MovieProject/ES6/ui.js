
class UI {

    static addFilmToUI(newFilm) {
        const filmList = document.getElementById("films")
        filmList.innerHTML += `
            <tr>
                <td><img src="${newFilm.url}" class="img-fluid img-thumbnail"></td>
                <td>${newFilm.title}</td>
                <td>${newFilm.director}</td>
                <td><a href="#" id="delete-film" class="btn btn-danger">Filmi Sil</a></td>
            </tr>    
        `
    }

    static clearInputs(element1, element2, element3) {
        element1.value = ""
        element2.value = ""
        element3.value = ""
    }

    static displayMessages(message, type) {
        const cardBody = document.querySelector(".card-body")
        // Alert divini olusturma
        const div = document.createElement("div")
        div.className = `alert alert-${type}`
        div.textContent = message

        cardBody.appendChild(div)
        setTimeout(() => div.remove(), 3000)
    }

    static deleteFilmFromUI(targetElement) {
        targetElement.parentElement.parentElement.remove()
    }

    static deleteAllFilmsFromUI() {
        const filmList = document.getElementById("films")
        while (filmList.firstElementChild !== null) {
            filmList.firstElementChild.remove()
        }
    }
}


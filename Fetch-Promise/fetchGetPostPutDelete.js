
class Request {

    get(url) {
        return new Promise((resolve, reject) => {
            fetch(url)
                .then(response => response.json())
                .then(json => resolve(json))
                .catch(err => reject(err))
        })
    }
    post(url, data) {
        return new Promise((resolve, reject) => {
            fetch(url, {
                method: 'POST',
                body: JSON.stringify(data),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8',
                }
            })
                .then(response => response.json())
                .then(json => resolve(json))
                .catch(err => reject(err))
        })
    }
    put(url, data) {
        return new Promise((resolve, reject) => {
            fetch(url, {
                method: 'PUT',
                body: JSON.stringify(data),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8',
                }
            })
                .then(response => response.json())
                .then(json => resolve(json))
                .catch(err => reject(err))
        })
    }
    delete(url) {
        return new Promise((resolve, reject) => {
            fetch(url, { method: "DELETE" })
                .then(() => resolve("Veri silme islemi basarili."))
                .catch(err => reject(err))
        })
    }
}

const request = new Request()

// request.get("https://jsonplaceholder.typicode.com/albums")
//     .then(albums => {
//         console.log(albums)
//     })
//     .catch(err => console.log(err))

// let album = { userId: 1, title: "post deneme title" }
// request.post("https://jsonplaceholder.typicode.com/albums", album)
//     .then(newAlbum => console.log(newAlbum))
//     .catch(err => console.log(err))

// let album = { userId: 5, title: "PUT deneme title" }
// request.put("https://jsonplaceholder.typicode.com/albums/12", album)
//     .then(newAlbum => console.log(newAlbum))
//     .catch(err => console.log(err))

request.delete("https://jsonplaceholder.typicode.com/albums55/16")
    .then(message => console.log(message))
    .catch(err => console.log(err))


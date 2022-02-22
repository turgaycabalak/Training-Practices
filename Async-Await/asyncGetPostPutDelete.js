
class Request {

    async get(url) {
        const response = await fetch(url) // Response object
        return await response.json() // Json object
    }

    async post(url, data) {
        const response = await fetch(url, {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            }
        })
        return await response.json()        
    }

    async put(url, data) {
        const response = await fetch(url, {
            method: 'PUT',
            body: JSON.stringify(data),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            }
        })
        return await response.json()
    }

    async delete(url) {
        const response = await fetch(url, { method: "DELETE" })
        return "Veri silme islemi basarili."
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

request.delete("https://jsonplaceholder.typicode.com/albums/16")
    .then(message => console.log(message))
    .catch(err => console.log(err))


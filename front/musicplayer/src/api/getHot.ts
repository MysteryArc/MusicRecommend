import axios from "../api/request";

function getPopular() {
    return new Promise((reslove,reject) => {
        axios.get("http://localhost:8080/api/hot").then(async res => {
            let hotList:IArtists[] = []
            let popularList:IPopular[] = []
            popularList = res.data.value
            for (let item of popularList) {
                let res = await axios.get("artists/id/" + item)
                hotList.push(res.data)
            }
            reslove(hotList)
        }).catch(err => {
            reject(err)
        })
    })
}

export default getPopular
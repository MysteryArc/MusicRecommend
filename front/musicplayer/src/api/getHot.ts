import axios from "../api/request";

function getPopular() {
    return new Promise((reslove,reject) => {
        axios.get("http://localhost:8087/api/popular").then(async res => {
            let hotList:IArtists[] = []
            let popularList:IPopular[] = []
            popularList = res.data
            for (let item of popularList) {
                let res = await axios.get("artists/id/" + item.Id)
                hotList.push(res.data)
            }
            reslove(hotList)
        }).catch(err => {
            reject(err)
        })
    })
    
}

export default getPopular
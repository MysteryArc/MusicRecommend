import axios from "../api/request";

function getRecommend(recommendId: string|number) {
    return new Promise((reslove,reject) => {
        axios.get("http://localhost:8080/recommend/user/" + recommendId).then(async res => {
            let recommendList: IArtists[] = []
            let resList:any = []
            if (res.data.value == null) {
                let res = await axios.get("http://localhost:8087/api/popular?user-id=" + recommendId)
                resList = res.data.value
                for (let item of resList) {
                    let res = await axios.get("artists/id/" + item.Id)
                    recommendList.push(res.data)
                }
            }
            else {
                resList = res.data.value
                for (let item of resList) {
                let res = await axios.get("artists/id/" + item.artistId)
                recommendList.push(res.data)
                }
            }
            reslove(recommendList)
        }).catch(err => {
            reject(err)
        })
    })
}

export default getRecommend
import axios from "../api/request";

function getRecommend(recommendId: string|number) {
    return new Promise((reslove,reject) => {
        axios.get("http://localhost:8087/api/recommend/" + recommendId).then(async res => {
            let recommendList: IArtists[] = []
            let resList:any = []
            if (res.data == null) {
                let res = await axios.get("http://localhost:8087/api/popular?user-id=" + recommendId)
                resList = res.data
                for (let item of resList) {
                    let res = await axios.get("artists/id/" + item.Id)
                    recommendList.push(res.data)
                }
            }
            else {
                resList = res.data
                for (let item of resList) {
                let res = await axios.get("artists/id/" + item)
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
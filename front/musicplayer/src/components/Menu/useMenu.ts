import { LocationStarFilled } from "@vicons/carbon"
import { MusicalNotes, HeartSharp, TimeSharp } from "@vicons/ionicons5"

export function useMenu() {
    const menus: IMenuList[] = [
        {
            name: "在线音乐",
            menus: [
                {
                    name: "推荐",
                    path: "/recommend",
                    key: "recommend",
                    icon: LocationStarFilled
                },
                {
                    name: "音乐馆",
                    path: "/show",
                    key: "show",
                    icon: MusicalNotes
                }
            ]
        },
        {
            name: "我的音乐",
            menus: [
                {
                    name: "我喜欢",
                    path: "/love",
                    key: "love",
                    icon: HeartSharp
                },
                {
                    name: "最近播放",
                    path: "/recently",
                    key: "recently",
                    icon: TimeSharp
                }
            ]
        }
    ]
    return menus
}
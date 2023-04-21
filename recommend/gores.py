import pymysql
import time
from gorse import Gorse

db = pymysql.connect(
    host="localhost",
    user="root",
    password="123456",
    database="music_recommend"
)

cursor = db.cursor() #创建游标对象

#用户查询
# usersql = "select id from user"
# cursor.execute(usersql)
# alluser = cursor.fetchall() #获取全部数据
# userres = []
# for i in alluser:
#     userres.append(
#         {
#             "UserId": str(i[0])
#         }
#     )

#音乐查询
# artistsres = []
# tags = []
# artistssql = "select id from artists"
# cursor.execute(artistssql)
# allartists = cursor.fetchall()
# for i in allartists:
#     tagsql = "select distinct ut.tag_id from artists a join user_tagged ut on a.id = ut.artists_id where a.id = %d" %(i)
#     cursor.execute(tagsql)
#     for j in cursor.fetchall():
#         tags.append(str(j[0]))
#     artistsres.append(
#         {
#             "ItemId": str(i[0]),
#             "Labels": tags[:]
#         }
#     )
#     tags.clear()

#查询反馈 喜欢、已读（物品Id、用户Id、反馈类型、时间）
# readfeedback = []
# likefeedback = []
# readsql = "select user_id, artists_id, timestamp from user_artists"
# likesql = "select user_id, artists_id, timestamp from user_like"

# cursor.execute(readsql)
# allread = cursor.fetchall()
# for read in allread:
#     readfeedback.append(
#         {
#             "FeedbackType": "read",
#             "UserId": str(read[0]),
#             "ItemId": str(read[1]),
#             "Timestamp": str(read[2])
#         }
#     )

# cursor.execute(likesql)
# alllike = cursor.fetchall()
# for like in alllike:
#     likefeedback.append(
#         {
#             "FeedbackType": "like",
#             "UserId": str(like[0]),
#             "ItemId": str(like[1]),
#             "Timestamp": str(like[2])
#         }
#     )

def main():
    #create
    client = Gorse('http://127.0.0.1:8087', '')

    # 插入用户
    # for i in userres:
    #     client.insert_user(i)

    # 插入音乐
    # for i in artistsres:
    #     client.insert_item(i)

    # # 插入已读反馈
    # client.insert_feedbacks(readfeedback)

    # # 插入积极反馈
    # client.insert_feedbacks(likefeedback)

    re = client.get_recommend("3", n=5)
main()
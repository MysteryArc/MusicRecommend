import pandas as pd
from math import sqrt
import operator
import sys

# 获取用户行为数据
def getData():
    df = pd.read_csv("C:/Users/MysteryArc/Desktop/love.csv",names=["user", "artist", "timestamp"])
    data = {}
    for i in range(df.shape[0]):
        user = df.iloc[i][0]
        artist = df.iloc[i][1]
        data.setdefault(user,{})
        data[user][artist] = 1
    return data

# 构造相似矩阵
def similarity(data):
    N={}#喜欢物品i的总人数
    C={}#喜欢物品i也喜欢物品j的人数
    for user,artist in data.items():
        for i,score in artist.items():
            N.setdefault(i,0)
            N[i]+=1
            C.setdefault(i,{})
            for j,scores in artist.items():
                if j != i:
                    C[i].setdefault(j,0)
                    C[i][j]+=1
    W={}
    for i,item in C.items():
        W.setdefault(i,{})
        for j,item2 in item.items():
            W[i].setdefault(j,0)
            W[i][j]=C[i][j]/sqrt(N[i]*N[j])
    return W

# 推荐物品
def recommandList(data,W,user,k=3,N=10):
    rank={}
    for i,score in data[user].items():	#获得用户user历史记录，如A用户的历史记录为{'a': '1', 'b': '1', 'd': '1'}
        for j,w in sorted(W[i].items(),key=operator.itemgetter(1),reverse=True)[0:k]:	#获得与物品i相似的k个物品
            if j not in data[user].keys():	#该相似的物品不在用户user的记录里
                rank.setdefault(j,0)
                rank[j]+=float(score) * w
                
    # print(sorted(rank.items(),key=operator.itemgetter(1),reverse=True)[0:N])
    return sorted(rank.items(),key=operator.itemgetter(1),reverse=True)[0:N]

if __name__ == '__main__':
    data = getData()
    W = similarity(data)
    userId = int(sys.argv[1])
    res = recommandList(data, W, userId)
    for i in res:
        print("%d,%f" %(i[0],i[1]))

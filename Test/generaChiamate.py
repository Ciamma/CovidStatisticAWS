import random as r

listaid = []
link_malato = "POST http://sviluppocovid.us-east-1.elasticbeanstalk.com/covidcounters/malato/"
link_guarito = "POST http://sviluppocovid.us-east-1.elasticbeanstalk.com/covidcounters/guarito/"
link_get = "GET http://sviluppocovid.us-east-1.elasticbeanstalk.com/covidcounters/nMalati"
link_get_guariti = "GET http://sviluppocovid.us-east-1.elasticbeanstalk.com/covidcounters/nGuariti"


def randomID():
    res = ''
    var = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    while len(res) < 10:
        res += var[r.randint(0, len(var)-1)]
    # print(res)
    return res


if __name__ == '__main__':
    i = 0
    f = open("target.list", "a")
    while i < 2000:
        idscelto = randomID()
        if idscelto not in listaid:
            listaid.append(idscelto)
            f.write(link_malato + idscelto)
            if i % 2 == 0:
                f.write(link_guarito + listaid[r.randint(0, len(listaid)-1)])
                i += 1
            if i % 3 == 0:
                f.write(link_get)
                f.write(link_get_guariti)
                i += 2
            i += 1
    f.close()

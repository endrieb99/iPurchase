import json

def main():
    result = {
                 "APIQueryCount":5000,
                 "IPScore":6.721,
                 "PurchaseAdvice":"We highly recommend you to proceed with the purchase. Analysis of comments and opinions from others users shows the iPhone 14 Pro Max is worth the hype",
                 "FrequentWords":{
                    "positive":[
                       "durable",
                       "long lasting battery",
                       "strong",
                       "screen",
                       "glare",
                       "color",
                       "heating",
                       "bright",
                       "image",
                       "quality",
                       "cracks",
                       "glass",
                       "screen protector",
                       "Face Id",
                       "microphone"
                    ],
                    "negative":[
                       "weak",
                       "battery",
                       "color",
                       "screen",
                       "glare",
                       "color",
                       "heating",
                       "bright",
                       "image",
                       "quality",
                       "cracks",
                       "glass",
                       "screen protector",
                       "Face Id",
                       "microphone"
                    ],
                    "neutral":[
                       "screen",
                       "audio",
                       "screen",
                       "glare",
                       "color",
                       "heating",
                       "bright",
                       "image",
                       "quality",
                       "cracks",
                       "glass",
                       "screen protector",
                       "Face Id",
                       "microphone"
                    ]
                 },
                 "Tweets":{
                    "negative":[
                       {
                          "Date":"2023-01-14 03:58:41",
                          "Favorites":0,
                          "ID":1614109723837739008,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Brisbane, Queensland",
                          "Retweets":0,
                          "Score":0.0,
                          "Tweets":"music app terrible lags try skip 1 song time iphone 14 pro max",
                          "polarity":-1.0,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-13 21:43:15",
                          "Favorites":1,
                          "ID":1614015241519779840,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"\u201894 | she/her ",
                          "Retweets":0,
                          "Score":0.0,
                          "Tweets":"iphone 14 pro max front camera insane",
                          "polarity":-1.0,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-13 22:34:58",
                          "Favorites":0,
                          "ID":1614028256147279880,
                          "Link":"http://twitter.com/download/android",
                          "Location":"Seattle",
                          "Retweets":0,
                          "Score":0.0,
                          "Tweets":"yup 14 pro max worst iphone ever owned",
                          "polarity":-1.0,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-14 00:43:37",
                          "Favorites":4,
                          "ID":1614060633649197057,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Houston, TX",
                          "Retweets":0,
                          "Score":0.0,
                          "Tweets":"speed iphone 14 pro max insane homescreen literally blink eye n",
                          "polarity":-1.0,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-14 20:07:13",
                          "Favorites":0,
                          "ID":1614353464464904193,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"England, United Kingdom",
                          "Retweets":0,
                          "Score":0.0,
                          "Tweets":"1 14 pro max worst iphone date",
                          "polarity":-1.0,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-14 15:12:38",
                          "Favorites":0,
                          "ID":1614279329034166277,
                          "Link":"http://twitter.com/download/android",
                          "Location":"South East, England",
                          "Retweets":0,
                          "Score":0.0,
                          "Tweets":"happened iphone 14 pro max awful experience",
                          "polarity":-1.0,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-14 14:01:37",
                          "Favorites":0,
                          "ID":1614261455943258115,
                          "Link":"https://mobile.twitter.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":0.9999999999999998,
                          "Tweets":"lodi646 christmas bonanza winners congratulations winners christmas bonanza rank 3 rank 4 winn",
                          "polarity":-0.8,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-14 14:02:20",
                          "Favorites":0,
                          "ID":1614261639003664384,
                          "Link":"https://mobile.twitter.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":0.9999999999999998,
                          "Tweets":"lodi646 christmas bonanza winners congratulations winners christmas bonanza rank 3 rank 4 winn",
                          "polarity":-0.8,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-13 22:18:31",
                          "Favorites":1,
                          "ID":1614024117216481285,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Sarawak, Malaysia",
                          "Retweets":0,
                          "Score":0.9999999999999998,
                          "Tweets":"know freaking annoying ayah ibu talks buying iphone 14 pro max said",
                          "polarity":-0.8,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-13 14:03:39",
                          "Favorites":0,
                          "ID":1613899579132416001,
                          "Link":"http://twitter.com/download/android",
                          "Location":"Nowhere, Earth",
                          "Retweets":0,
                          "Score":1.5000000000000009,
                          "Tweets":"think bad thing iphone 11 pro max iphone 13 pro max saw peak",
                          "polarity":-0.6999999999999998,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-14 02:59:08",
                          "Favorites":0,
                          "ID":1614094738881220608,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"United States",
                          "Retweets":0,
                          "Score":2.333333333333334,
                          "Tweets":"iphone 14 pro max camera insane realize bad camera old phone",
                          "polarity":-0.5333333333333332,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-12 11:52:12",
                          "Favorites":0,
                          "ID":1613504111579725826,
                          "Link":"http://twitter.com/download/android",
                          "Location":"General Trias City Cavite",
                          "Retweets":0,
                          "Score":2.5,
                          "Tweets":"dont want tesla dont garage amp expensive put charging aparatus",
                          "polarity":-0.5,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-13 14:29:44",
                          "Favorites":0,
                          "ID":1613906146011529219,
                          "Link":"https://ifttt.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":2.5,
                          "Tweets":"iphone 14 pro max specifications price iphone 14 pro max expensive pho",
                          "polarity":-0.5,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-11 21:37:41",
                          "Favorites":0,
                          "ID":1613289066409218063,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Portugal (Azores)",
                          "Retweets":0,
                          "Score":2.5,
                          "Tweets":"expensive already portugal iphone 14 pro max 128 gb 1499",
                          "polarity":-0.5,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-14 20:09:40",
                          "Favorites":0,
                          "ID":1614354078485577730,
                          "Link":"http://twitter.com/download/android",
                          "Location":"",
                          "Retweets":0,
                          "Score":2.5,
                          "Tweets":"ordered iphone 14 pro max apple store received fake iphone",
                          "polarity":-0.5,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-14 20:08:14",
                          "Favorites":0,
                          "ID":1614353718207553537,
                          "Link":"http://twitter.com/download/android",
                          "Location":"",
                          "Retweets":0,
                          "Score":2.5,
                          "Tweets":"ordered iphone 14 pro max apple store received fake iphone talk apple suppo",
                          "polarity":-0.5,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-13 14:09:45",
                          "Favorites":0,
                          "ID":1613901117678825475,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Charlotte, NC",
                          "Retweets":0,
                          "Score":2.5,
                          "Tweets":"weird cause brought iphone 14 pro max birthday",
                          "polarity":-0.5,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-13 14:07:05",
                          "Favorites":0,
                          "ID":1613900445835005953,
                          "Link":"https://dashboard.heropost.io/",
                          "Location":"Toronto, ON, Canada",
                          "Retweets":0,
                          "Score":2.5,
                          "Tweets":"caviar made expensive iphone 14 pro max 533 000 diamonds graff involved read",
                          "polarity":-0.5,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-14 05:20:13",
                          "Favorites":0,
                          "ID":1614130240967802880,
                          "Link":"https://mobile.twitter.com",
                          "Location":"Stormwind City",
                          "Retweets":0,
                          "Score":2.5,
                          "Tweets":"told iphone 14 pro max unlock phone using voiceid unfortunately nothing happened",
                          "polarity":-0.5,
                          "sentiment":"Negative"
                       },
                       {
                          "Date":"2023-01-14 12:17:01",
                          "Favorites":0,
                          "ID":1614235132185178112,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Los Angeles",
                          "Retweets":0,
                          "Score":3.0,
                          "Tweets":"iphone 14 pro max secret wireless charging upgrade tom guide",
                          "polarity":-0.4,
                          "sentiment":"Negative"
                       }
                    ],
                    "neutral":[
                       {
                          "Date":"2023-01-13 15:59:58",
                          "Favorites":0,
                          "ID":1613928854254682112,
                          "Link":"http://www.eversobling.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":4.166666666666667,
                          "Tweets":"gradation bear 3d bling swarovski crystal iphone 14 case iphone 14 pro iphone 14 pro max case black",
                          "polarity":-0.16666666666666666,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-13 20:24:33",
                          "Favorites":0,
                          "ID":1613995435529752577,
                          "Link":"https://dlvrit.com/",
                          "Location":"Vancouver, British Columbia",
                          "Retweets":0,
                          "Score":4.166666666666667,
                          "Tweets":"two iphone 14 pro max space black mockup",
                          "polarity":-0.16666666666666666,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-12 05:53:03",
                          "Favorites":5,
                          "ID":1613413730536288258,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"",
                          "Retweets":0,
                          "Score":4.166666666666667,
                          "Tweets":"countless odd bugs times music player show dynamic island random",
                          "polarity":-0.16666666666666666,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-13 19:08:33",
                          "Favorites":0,
                          "ID":1613976310208147461,
                          "Link":"https://dlvrit.com/",
                          "Location":"Vancouver, British Columbia",
                          "Retweets":0,
                          "Score":4.166666666666667,
                          "Tweets":"iphone 14 pro max space black mockup",
                          "polarity":-0.16666666666666666,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-12 14:47:32",
                          "Favorites":0,
                          "ID":1613548235410518016,
                          "Link":"https://dlvrit.com/",
                          "Location":"Vancouver, British Columbia",
                          "Retweets":0,
                          "Score":4.166666666666667,
                          "Tweets":"iphone 14 pro max space black mockup",
                          "polarity":-0.16666666666666666,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-13 17:00:35",
                          "Favorites":0,
                          "ID":1613944105503182850,
                          "Link":"https://dlvrit.com/",
                          "Location":"Vancouver, British Columbia",
                          "Retweets":0,
                          "Score":4.166666666666667,
                          "Tweets":"iphone 14 pro max space black mockup",
                          "polarity":-0.16666666666666666,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-14 10:10:53",
                          "Favorites":0,
                          "ID":1614203389998407683,
                          "Link":"https://ifttt.com",
                          "Location":"Basque Country, Spain",
                          "Retweets":0,
                          "Score":4.166666666666667,
                          "Tweets":"bought 14 pro max knowing uses esim previous iphone 11 would turn connect itunes sug",
                          "polarity":-0.16666666666666666,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-13 16:10:41",
                          "Favorites":0,
                          "ID":1613931548977528833,
                          "Link":"https://mobile.twitter.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":4.166666666666667,
                          "Tweets":"apple iphone 14 pro max 256gb space black",
                          "polarity":-0.16666666666666666,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-12 14:18:33",
                          "Favorites":0,
                          "ID":1613540942015000577,
                          "Link":"https://dlvrit.com/",
                          "Location":"Vancouver, British Columbia",
                          "Retweets":0,
                          "Score":4.166666666666667,
                          "Tweets":"iphone 14 pro max space black mockup",
                          "polarity":-0.16666666666666666,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-12 16:09:42",
                          "Favorites":1,
                          "ID":1613568912989515776,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Home",
                          "Retweets":0,
                          "Score":4.21875,
                          "Tweets":"mean ps5 iphone 14 pro max iphone 14 iphone 13 money back",
                          "polarity":-0.15625,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-12 02:26:12",
                          "Favorites":0,
                          "ID":1613361675343888387,
                          "Link":"http://poshmark.com/",
                          "Location":"on your mind!:)",
                          "Retweets":0,
                          "Score":4.25,
                          "Tweets":"check listing added closet magsafe silicon case iphone 14 pro max dark purple ipho",
                          "polarity":-0.15,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-12 13:49:51",
                          "Favorites":0,
                          "ID":1613533719943413760,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Durban, South Africa",
                          "Retweets":0,
                          "Score":4.25,
                          "Tweets":"guys iphone 14 pro max locking screen turn make completely dark",
                          "polarity":-0.15,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-12 05:43:05",
                          "Favorites":0,
                          "ID":1613411222854176768,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"\uff33\uff24 \u3001\uff23\uff21\u3000\u2225 \uff4f\uff41\uff48\uff55\u3001\uff28\uff29",
                          "Retweets":0,
                          "Score":4.25,
                          "Tweets":"want phone cases bad available iphone 14 pro max",
                          "polarity":-0.1499999999999999,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-12 09:33:29",
                          "Favorites":0,
                          "ID":1613469202739855363,
                          "Link":"https://www.eliteviser.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":4.270833333333333,
                          "Tweets":"idiskk mfi certified 4tb ipad iphone external hard drive android photo storage stick drive iphone 14 13 12 12 p",
                          "polarity":-0.14583333333333334,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-14 07:34:09",
                          "Favorites":0,
                          "ID":1614163948386885632,
                          "Link":"http://twitter.com/download/android",
                          "Location":"",
                          "Retweets":0,
                          "Score":4.333333333333334,
                          "Tweets":"sorry love iphone s23 colorway year unhealthy unmotivating lifeless 14",
                          "polarity":-0.13333333333333333,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-13 06:32:28",
                          "Favorites":0,
                          "ID":1613786035355361281,
                          "Link":"http://www.etsy.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":4.3686868686868685,
                          "Tweets":"new phone case mystical waves iphone 14 pro max 13 magsafe tough cases painting birthday anniversary glossy matt",
                          "polarity":-0.12626262626262627,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-13 06:03:29",
                          "Favorites":1,
                          "ID":1613778742614138882,
                          "Link":"http://www.etsy.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":4.3686868686868685,
                          "Tweets":"new phone case buy tough case",
                          "polarity":-0.12626262626262627,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-13 05:30:24",
                          "Favorites":4,
                          "ID":1613770416543129601,
                          "Link":"https://mobile.twitter.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":4.375,
                          "Tweets":"first world problems time engage silly debates gas vs electric iphone 1",
                          "polarity":-0.125,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-13 15:46:28",
                          "Favorites":1,
                          "ID":1613925455500906496,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"",
                          "Retweets":0,
                          "Score":4.375,
                          "Tweets":"using samsung s21 ultra 18 months returning pixel 7 pro due heat issues g",
                          "polarity":-0.125,
                          "sentiment":"Neutral"
                       },
                       {
                          "Date":"2023-01-14 10:20:25",
                          "Favorites":1,
                          "ID":1614205789513695233,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"",
                          "Retweets":0,
                          "Score":4.388888888888889,
                          "Tweets":"gussed since users complained pixel battery s22u battery less old s21 u",
                          "polarity":-0.12222222222222223,
                          "sentiment":"Neutral"
                       }
                    ],
                    "positive":[
                       {
                          "Date":"2023-01-14 00:15:30",
                          "Favorites":0,
                          "ID":1614053557233397762,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"6TEEN ",
                          "Retweets":0,
                          "Score":6.025,
                          "Tweets":"us 8 46 10 hot pearl high heel lipstick bling perfume bottle strap case iphone 1",
                          "polarity":0.20500000000000002,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-14 13:16:23",
                          "Favorites":0,
                          "ID":1614250074170687488,
                          "Link":"https://www.eliteviser.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":6.035714285714286,
                          "Tweets":"charger adapter 6 ports usb qc3 0 fast car charger qc3 0 3 1a 32v upgraded smart shunt car phone charger compa",
                          "polarity":0.20714285714285713,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-13 08:09:34",
                          "Favorites":0,
                          "ID":1613810471777275904,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Lavington Mall&Waterfront Krn",
                          "Retweets":0,
                          "Score":6.041666666666666,
                          "Tweets":"powerful fast elegant iphone 14 pro max get colors space black silver gold",
                          "polarity":0.20833333333333334,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-13 19:02:02",
                          "Favorites":0,
                          "ID":1613974672017686528,
                          "Link":"https://mobile.twitter.com",
                          "Location":"Slovak Republic",
                          "Retweets":0,
                          "Score":6.0606060606060606,
                          "Tweets":"new short iphone 14 pro max reach top via",
                          "polarity":0.21212121212121213,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-14 17:27:49",
                          "Favorites":0,
                          "ID":1614313349289746434,
                          "Link":"http://twitter.com/download/android",
                          "Location":"Lagos, Nigeria",
                          "Retweets":0,
                          "Score":6.071428571428571,
                          "Tweets":"certainly go iphone pro 14 max",
                          "polarity":0.21428571428571427,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-13 22:44:03",
                          "Favorites":1,
                          "ID":1614030542546124802,
                          "Link":"https://buffer.com",
                          "Location":"",
                          "Retweets":1,
                          "Score":6.083333333333333,
                          "Tweets":"whitestone dome ez glass screen protector iphone14 strong different quality",
                          "polarity":0.21666666666666665,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-14 15:55:20",
                          "Favorites":0,
                          "ID":1614290073117429763,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Sydney, New South Wales",
                          "Retweets":0,
                          "Score":6.142857142857143,
                          "Tweets":"special offers iphone 14 pro pro max contact 8861256880 place orders offer valid till 30 jan 2023",
                          "polarity":0.2285714285714286,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-14 10:52:14",
                          "Favorites":0,
                          "ID":1614213796863807494,
                          "Link":"https://mobile.twitter.com",
                          "Location":"South Africa",
                          "Retweets":0,
                          "Score":6.166666666666667,
                          "Tweets":"especially using old iphone rona ba 14 pro max cruising nicely",
                          "polarity":0.2333333333333333,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-12 17:08:17",
                          "Favorites":0,
                          "ID":1613583657754660877,
                          "Link":"https://www.mykapusta.com/post-studio",
                          "Location":"USA",
                          "Retweets":0,
                          "Score":6.166666666666667,
                          "Tweets":"selling 15 04 cute phone cases iphone 14 13 12 11 pro xs max xr 7 8 plus light green shop",
                          "polarity":0.2333333333333333,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-13 11:52:33",
                          "Favorites":0,
                          "ID":1613866587215257603,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Nairobi - kenya",
                          "Retweets":0,
                          "Score":6.170454545454546,
                          "Tweets":"iphone 14 pro max 256gb new free 20 watt power adapter free screen guard back cover trade ins accepted",
                          "polarity":0.2340909090909091,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-13 20:31:09",
                          "Favorites":1,
                          "ID":1613997098332221441,
                          "Link":"https://dlvrit.com/",
                          "Location":"",
                          "Retweets":2,
                          "Score":6.190476190476191,
                          "Tweets":"smart amp fun tips fast wireless charger 20w max wireless charging pad compatible iphone 14 14 plus 14 pro 14",
                          "polarity":0.23809523809523805,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-13 22:51:17",
                          "Favorites":0,
                          "ID":1614032364371419136,
                          "Link":"https://www.eliteviser.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":6.214285714285714,
                          "Tweets":"charger 10 ft 90 degree 3 pack nylon braided lightning cable right angle fast chargin",
                          "polarity":0.24285714285714285,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-14 17:24:14",
                          "Favorites":0,
                          "ID":1614312445878616067,
                          "Link":"https://mobile.twitter.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":6.215909090909091,
                          "Tweets":"1ds new square liquid silicone phone case iphone 11 12 13 14 pro max mini x xs max xr 7 8 plus se2 full protect",
                          "polarity":0.24318181818181817,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-13 02:58:38",
                          "Favorites":5,
                          "ID":1613732225765511168,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"20 | she/her | loassumptwt",
                          "Retweets":0,
                          "Score":6.215909090909091,
                          "Tweets":"remember im getting new iphone 14 pro max end week istg week full fulfi",
                          "polarity":0.24318181818181817,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-13 18:15:24",
                          "Favorites":0,
                          "ID":1613962933608022018,
                          "Link":"https://mobile.twitter.com",
                          "Location":"",
                          "Retweets":0,
                          "Score":6.215909090909091,
                          "Tweets":"cool new dragon phone cases stock check",
                          "polarity":0.24318181818181817,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-13 07:55:07",
                          "Favorites":0,
                          "ID":1613806834745282563,
                          "Link":"https://help.twitter.com/en/using-twitter/how-to-tweet#source-labels",
                          "Location":"",
                          "Retweets":0,
                          "Score":6.222222222222222,
                          "Tweets":"amazon deal found iphone super fast charger 20w usb c wall charger 6ft fast charging par",
                          "polarity":0.24444444444444446,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-11 22:55:07",
                          "Favorites":0,
                          "ID":1613308552583733248,
                          "Link":"https://help.twitter.com/en/using-twitter/how-to-tweet#source-labels",
                          "Location":"",
                          "Retweets":0,
                          "Score":6.222222222222222,
                          "Tweets":"amazon deal found iphone super fast charger 20w usb c wall charger 6ft fast charging par",
                          "polarity":0.24444444444444446,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-12 18:55:07",
                          "Favorites":1,
                          "ID":1613610543549382671,
                          "Link":"https://help.twitter.com/en/using-twitter/how-to-tweet#source-labels",
                          "Location":"",
                          "Retweets":0,
                          "Score":6.222222222222222,
                          "Tweets":"amazon deal found iphone super fast charger 20w usb c wall charger 6ft fast charging par",
                          "polarity":0.24444444444444446,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-14 04:21:01",
                          "Favorites":0,
                          "ID":1614115342762278914,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Vancouver, British Columbia",
                          "Retweets":0,
                          "Score":6.232954545454545,
                          "Tweets":"new iphone 14 pro max pretty solid feels smoother app transition 13 comparison nice featur",
                          "polarity":0.24659090909090908,
                          "sentiment":"Positive"
                       },
                       {
                          "Date":"2023-01-13 23:51:36",
                          "Favorites":0,
                          "ID":1614047545084313600,
                          "Link":"http://twitter.com/download/iphone",
                          "Location":"Ontario, Canada",
                          "Retweets":0,
                          "Score":6.25,
                          "Tweets":"first ios 16 bug faced iphone 14 pro max",
                          "polarity":0.25,
                          "sentiment":"Positive"
                       }
                    ]
                 }
              }

    return json.dumps(result)

def getReport():
    return main()
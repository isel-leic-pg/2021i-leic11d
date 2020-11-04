
data class Time(val h:Int, val m:Int, val s:Int)

fun secsToTime(secs :Int) = Time(secs/3600,secs%3600/60,secs%60)

fun timeToSecs(t :Time) = t.h*3600 + t.m*60 + t.s

fun toText(t :Time) = "${t.h}:${t.m}:${t.s}"

fun Time.toTxt() = "${this.h}:${this.m}:${this.s}"

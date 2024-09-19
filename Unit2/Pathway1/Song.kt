class Song(val title: String, val artist: String, val yearPublished: Int, val playCount: Double) {
    val isPopular : Boolean = if (playCount < 1000) false else true
    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}
package devfest.domain

interface KeyValueStorage {
    fun storeString(key: String, value: String)
    fun getString(key: String): String?
}
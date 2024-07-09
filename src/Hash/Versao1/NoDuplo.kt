package Hash.Versao1

data class NoDuplo (var dado: Any? = null) {
    var anterior: NoDuplo? = null
    var proximo: NoDuplo? = null
}
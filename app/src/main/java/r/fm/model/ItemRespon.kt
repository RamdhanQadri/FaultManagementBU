package r.fm.model

data class ItemRespon(
    val kelolaanSearches: List<ItemDamper>,
    val kelolaanSentra: List<ItemDamper>,
    val problemNt6Sentra: List<ItemDamper>,
    val problemOutInSentra: List<ItemDamper>,
    val slmSentra: List<ItemDamper>,

    //Out In
    val countProblemIn: List<ItemCountIn>,
    val countProbOut: List<ItemCountOut>,

    //Count All Out In dan SLM
    val countAllkelolaan: List<ItemCountAllKelolaan>,
    val countAllSlm: List<ItemCountAllSlm>,
    val countAllOut: List<ItemCountAllOut>,
    val countAllIn: List<ItemCountAllIn>,

    //---------------
    val problemNt24SSI: List<ItemDamper>,
    val slm: List<ItemDamper>,
    val slmKategori: List<ItemDamper>,
    val problemOutInSSI: List<ItemDamper>,
    val problemOutInKategori: List<ItemDamper>,

    //-------
    val selectAll: List<ItemDamper>,
    val SelectAllPortal: List<ItemPortal>,
    val DateHour : List<ItemDateHour>,
    val SelectTidFromSaldo: List<ItemSaldo>,
    val SelectAllFromSaldo: List<ItemSaldo>,
    val OpenProblem : List<ItemOpenProblem>,
    val OpenProblemOutIn : List<ItemOpenProblem>,
    val OpenProblemWarning : List<ItemOpenProblem>
)
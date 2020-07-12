    package com.zg.burgerjoint.dummy

    import com.et.padc_x_assignment4_eh.data.vos.TourVO


    fun getDummyBurgers() : List<TourVO>{
    val firstTour = TourVO()
        firstTour.id = 1
        firstTour.desc = "test description"
        firstTour.name = "test"
        firstTour.location = "test Location"
        firstTour.photos = arrayListOf()
        firstTour.rating = 0.0
        firstTour.reviews = arrayListOf()
        firstTour.copy()

    return arrayListOf(firstTour)
}
package com.example.alphabetlearning.data

import android.graphics.Point
import android.graphics.PointF
import com.example.alphabetlearning.model.*

object DataSkeleton {
    // Default Properties :
    private val defaultCurveTools = CurveTools()
    private val defaultMiddlePoint = MiddlePointTools(null, null)


    // _________________________________________________________________________________________
    // 1. ALEF :

    private val ALEF_Middle = MiddlePointTools(null, null)
    private val ALEF_Mid_Addi = MiddlePointTools(
        arrayListOf(PointF(875f, 150f), PointF(725f, 150f)),
        arrayListOf(CurveTools(25), defaultCurveTools, CurveTools(-25))
    )
    private val ALEF_Additional = arrayListOf<SkeletonShape>(
        SkeletonShape(PointF(900f, 125f), PointF(700f, 175f), ALEF_Mid_Addi, defaultCurveTools)
    )
    val ALEF_Skeleton_Cap = SkeletonShape(PointF(300f, 300f), PointF(300f, 700f), defaultCurveTools)
    val ALEF_Skeleton_Sm = SkeletonShape(PointF(800f, 300f), PointF(800f, 700f), ALEF_Middle, ALEF_Additional, defaultCurveTools)

    // _________________________________________________________________________________________
    // 2. Be :

    private val BE_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(850f, 550f)),
        arrayListOf(CurveTools(50), defaultCurveTools)
    )
    private val BE_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(850f, 650f), PointF(860f, 650f), defaultCurveTools, 2)
    )
    private val BE_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(500f, 550f), PointF(300f, 550f)),
        arrayListOf(CurveTools(50), defaultCurveTools, CurveTools(50))
    )
    private val BE_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(400f, 650f), PointF(410f, 650f), defaultCurveTools, 2)
    )
    val BE_Skeleton_Sm = SkeletonShape(PointF(900f, 500f), PointF(800f, 550f), BE_Middle_Sm, BE_Addi_Sm, defaultCurveTools)
    val BE_Skeleton_Cap = SkeletonShape(PointF(550f, 500f), PointF(250f, 500f), BE_Middle_Cap, BE_Addi_Cap, defaultCurveTools)

    // _________________________________________________________________________________________
    // 3. Pe : derived from BE

    private val PE_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(895f, 650f), PointF(885f, 650f), defaultCurveTools, 2),
        SkeletonShape(PointF(815f, 650f), PointF(825f, 650f), defaultCurveTools, 2),
        SkeletonShape(PointF(850f, 700f), PointF(860f, 700f), defaultCurveTools, 2)
    )

    private val PE_Addi_Cap = arrayListOf<SkeletonShape>(
        SkeletonShape(PointF(440f, 650f), PointF(450f, 650f), defaultCurveTools, 2),
        SkeletonShape(PointF(360f, 650f), PointF(370f, 650f), defaultCurveTools, 2),
        SkeletonShape(PointF(400f, 700f), PointF(410f, 700f), defaultCurveTools, 2)
    )
    val PE_Skeleton_Sm = SkeletonShape(PointF(900f, 500f), PointF(800f, 550f), BE_Middle_Sm, PE_Addi_Sm, defaultCurveTools)
    val PE_Skeleton_Cap = SkeletonShape(PointF(550f, 500f), PointF(250f, 500f), BE_Middle_Cap, PE_Addi_Cap, defaultCurveTools)

    // _________________________________________________________________________________________
    // 4. Te : derived from BE

    private val TE_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(895f, 450f), PointF(885f, 450f), defaultCurveTools, 2),
        SkeletonShape(PointF(815f, 450f), PointF(825f, 450f), defaultCurveTools, 2)
    )

    private val TE_Addi_Cap = arrayListOf<SkeletonShape>(
        SkeletonShape(PointF(440f, 450f), PointF(450f, 450f), defaultCurveTools, 2),
        SkeletonShape(PointF(360f, 450f), PointF(370f, 450f), defaultCurveTools, 2)
    )
    val TE_Skeleton_Sm = SkeletonShape(PointF(900f, 500f), PointF(800f, 550f), BE_Middle_Sm, TE_Addi_Sm, defaultCurveTools)
    val TE_Skeleton_Cap = SkeletonShape(PointF(550f, 500f), PointF(250f, 500f), BE_Middle_Cap, TE_Addi_Cap, defaultCurveTools)

    // _________________________________________________________________________________________
    // 5. Se : derived from BE

    private val SE_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(895f, 450f), PointF(885f, 450f), defaultCurveTools, 2),
        SkeletonShape(PointF(815f, 450f), PointF(825f, 450f), defaultCurveTools, 2),
        SkeletonShape(PointF(850f, 400f), PointF(860f, 400f), defaultCurveTools, 2)
    )
    private val SE_Addi_Cap = arrayListOf<SkeletonShape>(
        SkeletonShape(PointF(440f, 450f), PointF(450f, 450f), defaultCurveTools, 2),
        SkeletonShape(PointF(360f, 450f), PointF(370f, 450f), defaultCurveTools, 2),
        SkeletonShape(PointF(400f, 400f), PointF(410f, 400f), defaultCurveTools, 2)
    )

    val SE_Skeleton_Sm = SkeletonShape(PointF(900f, 500f), PointF(800f, 550f), BE_Middle_Sm, SE_Addi_Sm, defaultCurveTools)
    val SE_Skeleton_Cap = SkeletonShape(PointF(550f, 500f), PointF(250f, 500f), BE_Middle_Cap, SE_Addi_Cap, defaultCurveTools)

    // _________________________________________________________________________________________
    // 6. jim :

    private val Jim_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(850f, 500f), PointF(925f, 600f), PointF(650f, 600f)),
        arrayListOf(CurveTools(50), CurveTools(-25), defaultCurveTools, defaultCurveTools)
    )
    private val Jim_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(400f, 500f), PointF(475f, 600f), PointF(200f, 800f), PointF(450f, 1000f), PointF(200f, 800f)),
        arrayListOf(CurveTools(75), CurveTools(-25), CurveTools(-175), CurveTools(-175), CurveTools(175), CurveTools(175))
    )
    private val Jim_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(800f, 700f), PointF(810f, 700f), defaultCurveTools, 2)
    )
    private val Jim_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(400f, 800f), PointF(410f, 800f), defaultCurveTools, 2)
    )

    val JIM_Skeleton_Sm = SkeletonShape(PointF(750f, 500f), PointF(925f, 600f), Jim_Middle_Sm, Jim_Addi_Sm, defaultCurveTools, 20)
    val JIM_Skeleton_Cap = SkeletonShape(PointF(275f, 500f), PointF(475f, 600f), Jim_Middle_Cap, Jim_Addi_Cap, defaultCurveTools, 50)

    // _________________________________________________________________________________________
    // 7. Che : derived from Jim

    private val Che_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(775f, 700f), PointF(785f, 700f), defaultCurveTools, 2),
        SkeletonShape(PointF(850f, 700f), PointF(860f, 700f), defaultCurveTools, 2),
        SkeletonShape(PointF(815f, 750f), PointF(825f, 750f), defaultCurveTools, 2)
    )
    private val Che_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(375f, 800f), PointF(385f, 800f), defaultCurveTools, 2),
        SkeletonShape(PointF(450f, 800f), PointF(460f, 800f), defaultCurveTools, 2),
        SkeletonShape(PointF(415f, 850f), PointF(425f, 850f), defaultCurveTools, 2)
    )

    val Che_Skeleton_Sm = SkeletonShape(PointF(750f, 500f), PointF(925f, 600f), Jim_Middle_Sm, Che_Addi_Sm, defaultCurveTools, 20)
    val Che_Skeleton_Cap = SkeletonShape(PointF(275f, 500f), PointF(475f, 600f), Jim_Middle_Cap, Che_Addi_Cap, defaultCurveTools, 50)

    // _________________________________________________________________________________________
    // 8. he: derived from Jim

    val HE_Skeleton_Sm = SkeletonShape(PointF(750f, 500f), PointF(925f, 600f), Jim_Middle_Sm, defaultCurveTools, 20)
    val HE_Skeleton_Cap = SkeletonShape(PointF(275f, 500f), PointF(475f, 600f), Jim_Middle_Cap, defaultCurveTools, 50)

    // _________________________________________________________________________________________
    // 9. khe : derived form Jim

    private val Khe_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(800f, 350f), PointF(810f, 350f), defaultCurveTools, 2)
    )
    private val Khe_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(350f, 350f), PointF(360f, 350f), defaultCurveTools, 2)
    )

    val KHE_Skeleton_Sm = SkeletonShape(PointF(750f, 500f), PointF(925f, 600f), Jim_Middle_Sm, Khe_Addi_Sm, defaultCurveTools, 20)
    val KHE_Skeleton_Cap = SkeletonShape(PointF(275f, 500f), PointF(475f, 600f), Jim_Middle_Cap, Khe_Addi_Cap, defaultCurveTools, 50)

    // _________________________________________________________________________________________
    // 10. dal :

    private val DAL_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(700f, 850f)),
        arrayListOf(CurveTools(550), CurveTools(-550))
    )
    private val DAL_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(250f, 850f)),
        arrayListOf(CurveTools(550), CurveTools(-550))
    )

    val DAL_Skeleton_Sm = SkeletonShape(PointF(700f, 500f), PointF(700f, 500f), DAL_Middle_Sm, defaultCurveTools, 95)
    val DAL_Skeleton_Cap = SkeletonShape(PointF(250f, 500f), PointF(250f, 500f), DAL_Middle_Cap, defaultCurveTools, 95)

    // _________________________________________________________________________________________
    // 11. zal : derived from dal

    private val Zal_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(825f, 375f), PointF(835f, 375f), defaultCurveTools, 2)
    )
    private val Zal_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(375f, 375f), PointF(385f, 375f), defaultCurveTools, 2)
    )

    val ZAL_Skeleton_Sm = SkeletonShape(PointF(700f, 500f), PointF(700f, 500f), DAL_Middle_Sm, Zal_Addi_Sm, defaultCurveTools, 95)
    val ZAL_Skeleton_Cap = SkeletonShape(PointF(250f, 500f), PointF(250f, 500f), DAL_Middle_Cap, Zal_Addi_Cap, defaultCurveTools, 95)

    // _________________________________________________________________________________________
    // 12. re :

    val RE_Skeleton_Sm = SkeletonShape(PointF(850f, 550f), PointF(625f, 850f), CurveTools(150), 75)
    val RE_Skeleton_Cap = SkeletonShape(PointF(350f, 550f), PointF(125f, 850f), CurveTools(150), 75)

    // _________________________________________________________________________________________
    // 13. ze : derived from re

    private val Ze_Middle = MiddlePointTools(null, null)
    private val Ze_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(845f, 400f), PointF(855f, 400f), defaultCurveTools, 2)
    )
    private val Ze_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(345f, 400f), PointF(355f, 400f), defaultCurveTools, 2)
    )

    val ZE_Skeleton_Sm = SkeletonShape(PointF(850f, 550f), PointF(625f, 850f), Ze_Middle, Ze_Addi_Sm, CurveTools(150), 75)
    val ZE_Skeleton_Cap = SkeletonShape(PointF(350f, 550f), PointF(125f, 850f), Ze_Middle, Ze_Addi_Cap, CurveTools(150), 75)

    // _________________________________________________________________________________________
    // 14. zhe : derived from re and ze

    private val Zhe_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(800f, 400f), PointF(810f, 400f), defaultCurveTools, 2),
        SkeletonShape(PointF(890f, 400f), PointF(900f, 400f), defaultCurveTools, 2),
        SkeletonShape(PointF(845f, 325f), PointF(855f, 325f), defaultCurveTools, 2)

    )
    private val Zhe_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(300f, 400f), PointF(310f, 400f), defaultCurveTools, 2),
        SkeletonShape(PointF(390f, 400f), PointF(400f, 400f), defaultCurveTools, 2),
        SkeletonShape(PointF(345f, 325f), PointF(355f, 325f), defaultCurveTools, 2)
    )

    val ZHE_Skeleton_Sm = SkeletonShape(PointF(850f, 550f), PointF(625f, 850f), Ze_Middle, Zhe_Addi_Sm, CurveTools(150), 75)
    val ZHE_Skeleton_Cap = SkeletonShape(PointF(350f, 550f), PointF(125f, 850f), Ze_Middle, Zhe_Addi_Cap, CurveTools(150), 75)

    // _________________________________________________________________________________________
    // 15. sin :

    private val curve = CurveTools(50, 80)
    private val curveRevs = CurveTools(50, 20)
    private val capCurve = CurveTools(150, 75)
    private val capCurveRevs = CurveTools(150, 25)
    private val Sin_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(900f, 750f), PointF(850f, 650f), PointF(800f, 750f), PointF(750f, 650f), PointF(700f, 750f), PointF(675f, 750f), PointF(700f, 750f), PointF(750f, 650f), PointF(700f, 750f), PointF(675f, 750f), PointF(700f, 750f)),
        arrayListOf(curve, curveRevs, curve, curveRevs, curve, defaultCurveTools, defaultCurveTools, CurveTools(-50, 20), curve, defaultCurveTools, defaultCurveTools, CurveTools(-50, 20))
    )
    private val Sin_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(550f, 750f), PointF(500f, 650f), PointF(450f, 750f), PointF(400f, 650f), PointF(250f, 900f), PointF(100f, 650f), PointF(250f, 900f), PointF(400f, 650f), PointF(250f, 900f)),
        arrayListOf(curve, curveRevs, curve, curveRevs, capCurve, capCurveRevs, CurveTools(-150, 75), CurveTools(-150, 25), capCurve, capCurveRevs)
    )

    val SIN_Skeleton_Sm = SkeletonShape(PointF(950f, 650f), PointF(750f, 650f), Sin_Middle_Sm, defaultCurveTools, 120)
    val SIN_Skeleton_Cap = SkeletonShape(PointF(600f, 650f), PointF(100f, 650f), Sin_Middle_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 16. shin : Derived from sin

    private val Shin_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(800f, 500f), PointF(810f, 500f), defaultCurveTools, 2),
        SkeletonShape(PointF(890f, 500f), PointF(900f, 500f), defaultCurveTools, 2),
        SkeletonShape(PointF(845f, 425f), PointF(855f, 425f), defaultCurveTools, 2)

    )
    private val Shin_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(450f, 500f), PointF(460f, 500f), defaultCurveTools, 2),
        SkeletonShape(PointF(540f, 500f), PointF(550f, 500f), defaultCurveTools, 2),
        SkeletonShape(PointF(495f, 425f), PointF(505f, 425f), defaultCurveTools, 2)
    )

    val SHIN_Skeleton_Sm = SkeletonShape(PointF(950f, 650f), PointF(750f, 650f), Sin_Middle_Sm, Shin_Addi_Sm, defaultCurveTools, 120)
    val SHIN_Skeleton_Cap = SkeletonShape(PointF(600f, 650f), PointF(100f, 650f), Sin_Middle_Cap, Shin_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 17. sad :

    private val Sad_Middle_Sm = MiddlePointTools(
        arrayListOf(
            PointF(900f, 650f),
            PointF(1000f, 700f),
            PointF(900f, 750f),
            PointF(800f, 750f),
            PointF(725f, 650f),
            PointF(650f, 750f),
            PointF(650f, 750f),
            PointF(650f, 750f),
            PointF(725f, 650f),
            PointF(800f, 750f),
            PointF(900f, 750f),
            PointF(800f, 750f),
            PointF(725f, 650f),
            PointF(650f, 750f),
            PointF(650f, 750f),
        ),
        arrayListOf(
            CurveTools(50),
            CurveTools(50, 80),
            CurveTools(25),
            defaultCurveTools,
            CurveTools(75),
            CurveTools(75),
            defaultCurveTools,
            defaultCurveTools,
            CurveTools(-75),
            CurveTools(-75),
            defaultCurveTools,
            defaultCurveTools,
            CurveTools(75),
            CurveTools(75),
            defaultCurveTools,
            defaultCurveTools
        )
    )

    private val Sad_Middle_Cap = MiddlePointTools(
        arrayListOf(
            PointF(475f, 650f),
            PointF(575f, 700f),
            PointF(475f, 750f),
            PointF(375f, 750f),
            PointF(325f, 750f),
            PointF(200f, 950f),
            PointF(75f, 750f),
            PointF(200f, 950f),
            PointF(325f, 750f),
        ),
        arrayListOf(
            CurveTools(50),
            CurveTools(50, 80),
            CurveTools(25),
            defaultCurveTools,
            defaultCurveTools,
            CurveTools(150, 60),
            CurveTools(150, 40),
            CurveTools(-150, 60),
            CurveTools(-150, 40),
            CurveTools(150, 60),
        )
    )

    val SAD_Skeleton_Sm = SkeletonShape(PointF(800f, 750f), PointF(650f, 750f), Sad_Middle_Sm, defaultCurveTools, 120)
    val SAD_Skeleton_Cap = SkeletonShape(PointF(375f, 750f), PointF(200f, 950f), Sad_Middle_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 18 . ZAD : derived from Sad

    private val Zad_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(900f, 500f), PointF(910f, 500f), defaultCurveTools, 2)
    )
    private val Zad_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(475f, 500f), PointF(485f, 500f), defaultCurveTools, 2)
    )

    val ZAD_Skeleton_Sm = SkeletonShape(PointF(800f, 750f), PointF(650f, 750f), Sad_Middle_Sm, Zad_Addi_Sm, defaultCurveTools, 120)
    val ZAD_Skeleton_Cap = SkeletonShape(PointF(375f, 750f), PointF(200f, 950f), Sad_Middle_Cap, Zad_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 19. TA :

    private val Ta_Curve = arrayListOf(
        CurveTools(50),
        CurveTools(50, 80),
        CurveTools(25),
        defaultCurveTools,
        defaultCurveTools,
        defaultCurveTools,
        defaultCurveTools,
        defaultCurveTools,
        defaultCurveTools,
        defaultCurveTools,
        defaultCurveTools,
    )
    private val Ta_Middle_Sm = MiddlePointTools(
        arrayListOf(
            PointF(800f, 650f),
            PointF(900f, 700f),
            PointF(800f, 750f),
            PointF(700f, 750f),
            PointF(600f, 750f),
            PointF(700f, 750f),
            PointF(600f, 750f),
            PointF(700f, 750f),
            PointF(600f, 750f),
            PointF(700f, 750f),
        ),
        Ta_Curve
    )

    private val Ta_Middle_Cap = MiddlePointTools(
        arrayListOf(
            PointF(400f, 650f),
            PointF(500f, 700f),
            PointF(400f, 750f),
            PointF(300f, 750f),
            PointF(200f, 750f),
            PointF(300f, 750f),
            PointF(200f, 750f),
            PointF(300f, 750f),
            PointF(200f, 750f),
            PointF(300f, 750f)
        ),
        Ta_Curve
    )

    private val Ta_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(700f, 750f), PointF(700f, 500f), defaultCurveTools, 20)
    )
    private val Ta_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(300f, 750f), PointF(300f, 500f), defaultCurveTools, 20)
    )
    val TA_Skeleton_Sm = SkeletonShape(PointF(700f, 750f), PointF(600f, 750f), Ta_Middle_Sm, Ta_Addi_Sm, defaultCurveTools, 150)
    val TA_Skeleton_Cap = SkeletonShape(PointF(300f, 750f), PointF(200f, 750f), Ta_Middle_Cap, Ta_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 20. ZA : derived from TA

    private val Za_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(700f, 750f), PointF(700f, 500f), defaultCurveTools, 20),
        SkeletonShape(PointF(800f, 475f), PointF(810f, 475f), defaultCurveTools, 2)
    )
    private val Za_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(300f, 750f), PointF(300f, 500f), defaultCurveTools, 20),
        SkeletonShape(PointF(400f, 475f), PointF(410f, 475f), defaultCurveTools, 2)
    )

    val ZA_Skeleton_Sm = SkeletonShape(PointF(700f, 750f), PointF(600f, 750f), Ta_Middle_Sm, Za_Addi_Sm, defaultCurveTools, 150)
    val ZA_Skeleton_Cap = SkeletonShape(PointF(300f, 750f), PointF(200f, 750f), Ta_Middle_Cap, Za_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 21. EYN :

    //    private val middleCurveEyn = MiddlePointTools(
//        arrayListOf(PointF(450f, 1100f) , PointF(300f ,750f)),
//        arrayListOf(CurveTools(-450 , 50) ,CurveTools(450 , 50) ,CurveTools(-450 , 50))
//    )
    private val Eyn_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(850f, 750f), PointF(625f, 750f), defaultCurveTools, 30)
    )
    private var Eyn_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(400f, 750f), PointF(300f, 750f), defaultCurveTools, 35),
        SkeletonShape(PointF(300f, 750f), PointF(300f, 1100f), defaultMiddlePoint, CurveTools(-300, 75), 50),
        SkeletonShape(PointF(300f, 1100f), PointF(450f, 1075f), defaultMiddlePoint, CurveTools(-30), 50),
    )

    val EYN_Skeleton_Sm = SkeletonShape(PointF(850f, 600f), PointF(750f, 750f), defaultMiddlePoint, Eyn_Addi_Sm, CurveTools(-150, 40), 50)
    val EYN_Skeleton_Cap = SkeletonShape(PointF(400f, 600f), PointF(300f, 750f), defaultMiddlePoint, Eyn_Addi_Cap, CurveTools(-150, 40), 50)

    // _________________________________________________________________________________________
    // 22.GHYN : derived from EYN

    private val Ghyn_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(850f, 750f), PointF(625f, 750f), defaultCurveTools, 30)

    )
    private var Ghyn_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(400f, 750f), PointF(300f, 750f), defaultCurveTools, 100),
        SkeletonShape(PointF(300f, 750f), PointF(300f, 1100f), defaultMiddlePoint, CurveTools(-300, 75), 100),
        SkeletonShape(PointF(300f, 1100f), PointF(450f, 1075f), defaultMiddlePoint, CurveTools(-30), 100)

    )

    val GHYN_Skeleton_Sm = SkeletonShape(PointF(850f, 600f), PointF(750f, 750f), defaultMiddlePoint, Ghyn_Addi_Sm, CurveTools(-150, 40), 50)
    val GHYN_Skeleton_Cap = SkeletonShape(PointF(400f, 600f), PointF(300f, 750f), defaultMiddlePoint, Ghyn_Addi_Cap, CurveTools(-150, 40), 100)

    // _________________________________________________________________________________________
    // 23. Fe :

    private val Fe_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(750f, 750f), PointF(825f, 650f), PointF(900f, 750f), PointF(875f, 850f), PointF(700f, 850f), PointF(875f, 850f), PointF(700f, 850f), PointF(875f, 850f)),
        arrayListOf(defaultCurveTools, CurveTools(60), CurveTools(60), CurveTools(25, 65), defaultCurveTools, defaultCurveTools, defaultCurveTools, defaultCurveTools, defaultCurveTools)
    )
    private val Fe_Middle_Cap = MiddlePointTools(
        arrayListOf(
            PointF(450f, 750f),
            PointF(525f, 650f),
            PointF(600f, 750f),
            PointF(575f, 850f),
            PointF(400f, 850f),
            PointF(150f, 850f),
            PointF(100f, 750f),
            PointF(150f, 850f),
            PointF(400f, 850f),
            PointF(575f, 850f),
            PointF(400f, 850f),
            PointF(150f, 850f)
        ),
        arrayListOf(
            defaultCurveTools, CurveTools(60), CurveTools(60), CurveTools(25, 65), defaultCurveTools, defaultCurveTools, CurveTools(50), CurveTools(-50), defaultCurveTools, defaultCurveTools, defaultCurveTools, defaultCurveTools,
            defaultCurveTools
        )
    )
    private val Fe_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(825f, 500f), PointF(840f, 500f), defaultCurveTools, 2)
    )
    private val Fe_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(525f, 500f), PointF(540f, 500f), defaultCurveTools, 2)
    )

    val FE_Skeleton_Sm = SkeletonShape(PointF(900f, 750f), PointF(700f, 850f), Fe_Middle_Sm, Fe_Addi_Sm, defaultCurveTools, 100)
    val FE_Skeleton_Cap = SkeletonShape(PointF(600f, 750f), PointF(400f, 850f), Fe_Middle_Cap, Fe_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 24 . QAF :

    private val Qaf_Middle_Cap = MiddlePointTools(
        arrayListOf(
            PointF(400f, 750f),
            PointF(475f, 650f),
            PointF(550f, 750f),
            PointF(550f, 850f),
            PointF(350f, 1000f),
            PointF(150f, 850f),
            PointF(150f, 750f),
            PointF(150f, 850f),
            PointF(350f, 1000f),
            PointF(550f, 850f),
            PointF(350f, 1000f),
            PointF(150f, 850f),

            ),
        arrayListOf(
            defaultCurveTools, CurveTools(60), CurveTools(60), CurveTools(5),
            CurveTools(100), CurveTools(100), CurveTools(5),
            CurveTools(-5), CurveTools(-100), CurveTools(-100),
            CurveTools(100), CurveTools(100), CurveTools(5)
        )
    )
    private val Qaf_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(900f, 500f), PointF(885f, 500f), defaultCurveTools, 2),
        SkeletonShape(PointF(800f, 500f), PointF(785f, 500f), defaultCurveTools, 2),
    )
    private val Qaf_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(550f, 500f), PointF(535f, 500f), defaultCurveTools, 2),
        SkeletonShape(PointF(450f, 500f), PointF(435f, 500f), defaultCurveTools, 2),
    )

    val QAF_Skeleton_Sm = SkeletonShape(PointF(900f, 750f), PointF(700f, 850f), Fe_Middle_Sm, Qaf_Addi_Sm, defaultCurveTools, 100)
    val QAF_Skeleton_Cap = SkeletonShape(PointF(550f, 750f), PointF(150f, 750f), Qaf_Middle_Cap, Qaf_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 25. KAF :

    private val Kaf_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(850f, 850f), PointF(800f, 950f), PointF(700f, 950f)),
        arrayListOf(defaultCurveTools, CurveTools(40), defaultCurveTools, defaultCurveTools)
    )
    private val Kaf_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(550f, 850f), PointF(500f, 950f), PointF(150f, 950f), PointF(100f, 850f), PointF(150f, 950f)),
        arrayListOf(defaultCurveTools, CurveTools(40), defaultCurveTools, CurveTools(40, 25), CurveTools(-40, 75), defaultCurveTools)
    )
    private val Kaf_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(850f, 525f), PointF(1000f, 300f), defaultCurveTools, 50),
    )
    private val Kaf_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(550f, 525f), PointF(800f, 300f), defaultCurveTools, 50),
    )

    val KAF_Skeleton_Sm = SkeletonShape(PointF(850f, 550f), PointF(750f, 950f), Kaf_Middle_Sm, Kaf_Addi_Sm, defaultCurveTools, 100)
    val KAF_Skeleton_Cap = SkeletonShape(PointF(550f, 550f), PointF(500f, 950f), Kaf_Middle_Cap, Kaf_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 26. GAF : derived from KAF

    private val Gaf_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(850f, 525f), PointF(1000f, 300f), defaultCurveTools, 50),
        SkeletonShape(PointF(850f, 375f), PointF(1000f, 150f), defaultCurveTools, 50)
    )
    private val Gaf_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(550f, 525f), PointF(800f, 300f), defaultCurveTools, 50),
        SkeletonShape(PointF(550f, 375f), PointF(800f, 150f), defaultCurveTools, 50),
    )

    val GAF_Skeleton_Sm = SkeletonShape(PointF(850f, 550f), PointF(750f, 950f), Kaf_Middle_Sm, Gaf_Addi_Sm, defaultCurveTools, 100)
    val GAF_Skeleton_Cap = SkeletonShape(PointF(550f, 550f), PointF(500f, 950f), Kaf_Middle_Cap, Gaf_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 27 . LAM :

    private val Lam_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(500f, 850f), PointF(350f, 1100f), CurveTools(150, 75), 40),
        SkeletonShape(PointF(350f, 1100f), PointF(200f, 850f), CurveTools(150, 25), 40),
    )

    val LAM_Skeleton_Sm = SkeletonShape(PointF(850f, 550f), PointF(750f, 950f), Kaf_Middle_Sm, defaultCurveTools, 100)
    val LAM_Skeleton_Cap = SkeletonShape(PointF(500f, 550f), PointF(500f, 850f), defaultMiddlePoint, Lam_Addi_Cap, defaultCurveTools, 50)

    // _________________________________________________________________________________________
    // 28. MIM :

    private val Mim_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(700f, 650f), PointF(775f, 800f), PointF(850f, 650f), PointF(600f, 650f), PointF(850f, 650f)),
        arrayListOf(defaultCurveTools, CurveTools(-75, 70), CurveTools(-75, 30), defaultCurveTools, defaultCurveTools, defaultCurveTools)
    )
    private val Mim_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(300f, 650f), PointF(375f, 800f), PointF(450f, 650f), PointF(225f, 650f), PointF(200f, 675f), PointF(200f, 1100f), PointF(200f, 675f), PointF(200f, 1100f)),
        arrayListOf(defaultCurveTools, CurveTools(-75, 70), CurveTools(-75, 30), defaultCurveTools, CurveTools(-15), defaultCurveTools, defaultCurveTools, defaultCurveTools, defaultCurveTools)
    )

    val MIM_Skeleton_Sm = SkeletonShape(PointF(850f, 650f), PointF(600f, 650f), Mim_Middle_Sm, defaultCurveTools, 100)
    val MIM_Skeleton_Cap = SkeletonShape(PointF(450f, 650f), PointF(200f, 675f), Mim_Middle_Cap, defaultCurveTools, 100)

    // _________________________________________________________________________________________
    // 29 . NOON : derived from Be

    private val Noon_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(900f, 725f), PointF(875f, 750f), PointF(750f, 750f), PointF(875f, 750f)),
        arrayListOf(defaultCurveTools, CurveTools(15), defaultCurveTools, defaultCurveTools, defaultCurveTools)
    )
    private val Noon_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(400f, 1000f), PointF(250f, 750f), PointF(400f, 1000f)),
        arrayListOf(CurveTools(215), CurveTools(215), CurveTools(-215), CurveTools(-215))
    )
    private val Noon_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(800f, 550f), PointF(815f, 550f), defaultCurveTools, 2)
    )
    private val Noon_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(400f, 600f), PointF(415f, 600f), defaultCurveTools, 2)
    )

    val NOON_Skeleton_Sm = SkeletonShape(PointF(900f, 650f), PointF(750f, 750f), Noon_Middle_Sm, Noon_Addi_Sm, defaultCurveTools, 50)
    val NOON_Skeleton_Cap = SkeletonShape(PointF(550f, 750f), PointF(550f, 750f), Noon_Middle_Cap, Noon_Addi_Cap, defaultCurveTools, 100)
    // _________________________________________________________________________________________
    // 30.  VAV :

    private val Vav_middle_Sm = MiddlePointTools(
        arrayListOf(PointF(675f, 650f), PointF(850f, 650f), PointF(625f, 950f), PointF(850f, 650f)),
        arrayListOf(CurveTools(150), CurveTools(275), CurveTools(150), CurveTools(-150), CurveTools(150))
    )
    private val Vav_middle_Cap = MiddlePointTools(
        arrayListOf(PointF(275f, 650f), PointF(450f, 650f), PointF(225f, 950f), PointF(450f, 650f)),
        arrayListOf(CurveTools(150), CurveTools(275), CurveTools(150), CurveTools(-150), CurveTools(150))
    )

    val VAV_Skeleton_Sm = SkeletonShape(PointF(850f, 650f), PointF(625f, 950f), Vav_middle_Sm, defaultCurveTools, 100)
    val VAV_Skeleton_Cap = SkeletonShape(PointF(450f, 650f), PointF(225f, 950f), Vav_middle_Cap, defaultCurveTools, 100)

    // _________________________________________________________________________________________
    // 31 . HEdo:

//    private val HEdo_Middle_Sm = MiddlePointTools(
//        arrayListOf(PointF(900f, 850f), PointF(675f, 850f), PointF(750f, 650f), PointF(675f, 850f), PointF(750f, 650f), PointF(840f, 720f), PointF(675f, 850f)),
//        arrayListOf(CurveTools(100), CurveTools(25, 10), CurveTools(100), CurveTools(-100), CurveTools(100), CurveTools(40), CurveTools(20) , defaultCurveTools)
//    )

    private val HEdo_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(900f, 850f), PointF(675f, 850f), PointF(750f, 650f), PointF(675f, 850f), PointF(750f, 650f)),
        arrayListOf(CurveTools(100), CurveTools(25, 10), CurveTools(100), CurveTools(-100), CurveTools(100), CurveTools(-100))
    )
    private val HEdo_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(325f, 850f), PointF(325f, 625f), PointF(150f, 700f), PointF(325f, 750f), PointF(150f, 700f)),
        arrayListOf(defaultCurveTools, CurveTools(25, 10), CurveTools(-125), CurveTools(-125), CurveTools(125), CurveTools(125))
    )
    private val HEdo_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(835f, 715f), PointF(690f, 835f), CurveTools(20), 25),
        SkeletonShape(PointF(655f, 850f), PointF(575f, 850f), defaultCurveTools, 10)
    )

    val HEdo_Skeleton_Sm = SkeletonShape(PointF(750f, 650f), PointF(675f, 850f), HEdo_Middle_Sm, HEdo_Addi_Sm, defaultCurveTools, 100)
    val HEdo_Skeleton_Cap = SkeletonShape(PointF(425f, 850f), PointF(325f, 625f), HEdo_Middle_Cap, defaultCurveTools, 100)

    // _________________________________________________________________________________________
    // 32 . YE : derived from Noon

    private val Ye_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(800f, 900f), PointF(785f, 900f), defaultCurveTools, 2),
        SkeletonShape(PointF(850f, 900f), PointF(865f, 900f), defaultCurveTools, 2)
    )
    private val Ye_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(400f, 800f) , PointF(525f , 900f) , PointF(400f, 1100f),PointF(200f, 750f),PointF(400f, 1100f),PointF(525f , 900f),PointF(400f, 1100f)),
        arrayListOf(CurveTools(-75), CurveTools(-50 , 25) , CurveTools(100 , 40), CurveTools(400) , CurveTools(-400) ,CurveTools(-100 , 60),CurveTools(100 , 40), CurveTools(400))
    )

    val YE_Skeleton_Sm = SkeletonShape(PointF(900f, 650f), PointF(750f, 750f), Noon_Middle_Sm, Ye_Addi_Sm, defaultCurveTools, 50)
    val YE_Skeleton_Cap = SkeletonShape(PointF(550f, 700f), PointF(200f, 750f), Ye_Middle_Cap, defaultCurveTools, 175)

    // _________________________________________________________________________________________


}

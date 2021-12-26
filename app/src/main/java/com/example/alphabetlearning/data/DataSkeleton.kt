package com.example.alphabetlearning.data

import android.graphics.PointF
import com.example.alphabetlearning.model.*

object DataSkeleton {
    // Default Properties :
    private var SWidth = ScreenTool.width
    private var SHeight = ScreenTool.height
    private val defaultCurveTools = CurveTools()
    private val defaultMiddlePoint = MiddlePointTools(null, null)
    private val defaultAdditional: ArrayList<SkeletonShape> = arrayListOf()

    // _________________________________________________________________________________________
    // 1. ALEF :

    private val ALEF_Mid_Addi = MiddlePointTools(
        arrayListOf(PointF(SWidth * 0.9f, SHeight * 0.2f), PointF(SWidth * 0.6f, SHeight * 0.2f)),
        arrayListOf(CurveTools(10), defaultCurveTools, CurveTools(-10))
    )
    private val ALEF_Additional = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.9f, SHeight * 0.175f), PointF(SWidth * 0.6f, SHeight * 0.225f), ALEF_Mid_Addi, defaultAdditional, defaultCurveTools, 25)
    )
    val ALEF_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.25f, SHeight * 0.3f), PointF(SWidth * 0.25f, SHeight * 0.6f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 50)
    val ALEF_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.75f, SHeight * 0.3f), PointF(SWidth * 0.75f, SHeight * 0.6f), defaultMiddlePoint, ALEF_Additional, defaultCurveTools, 50)

    // _________________________________________________________________________________________
    // 2. Be :

    private val BE_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(SWidth * 0.8f, SHeight * 0.45f)),
        arrayListOf(CurveTools(50), defaultCurveTools)
    )
    private val BE_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.775f, SHeight * 0.55f), PointF(SWidth * 0.79f, SHeight * 0.55f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val BE_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(SWidth * 0.5f, SHeight * 0.45f), PointF(SWidth * 0.2f, SHeight * 0.45f)),
        arrayListOf(CurveTools(50), defaultCurveTools, CurveTools(50))
    )
    private val BE_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.35f, SHeight * 0.55f), PointF(SWidth * 0.365f, SHeight * 0.55f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    val BE_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.85f, SHeight * 0.4f), PointF(SWidth * 0.7f, SHeight * 0.45f), BE_Middle_Sm, BE_Addi_Sm, defaultCurveTools, 30)
    val BE_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.55f, SHeight * 0.4f), PointF(SWidth * 0.15f, SHeight * 0.4f), BE_Middle_Cap, BE_Addi_Cap, defaultCurveTools, 80)

    // _________________________________________________________________________________________
    // 3. Pe : derived from BE

    private val PE_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.81f, SHeight * 0.55f), PointF(SWidth * 0.825f, SHeight * 0.55f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.72f, SHeight * 0.55f), PointF(SWidth * 0.735f, SHeight * 0.55f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.765f, SHeight * 0.6f), PointF(SWidth * 0.78f, SHeight * 0.6f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    private val PE_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.395f, SHeight * 0.55f), PointF(SWidth * 0.41f, SHeight * 0.55f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.305f, SHeight * 0.55f), PointF(SWidth * 0.32f, SHeight * 0.55f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.35f, SHeight * 0.6f), PointF(SWidth * 0.365f, SHeight * 0.6f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    val PE_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.85f, SHeight * 0.4f), PointF(SWidth * 0.7f, SHeight * 0.45f), BE_Middle_Sm, PE_Addi_Sm, defaultCurveTools, 30)
    val PE_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.55f, SHeight * 0.4f), PointF(SWidth * 0.15f, SHeight * 0.4f), BE_Middle_Cap, PE_Addi_Cap, defaultCurveTools, 80)

    // _________________________________________________________________________________________
    // 4. Te : derived from BE

    private val TE_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.81f, SHeight * 0.325f), PointF(SWidth * 0.825f, SHeight * 0.325f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.72f, SHeight * 0.325f), PointF(SWidth * 0.735f, SHeight * 0.325f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    private val TE_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.395f, SHeight * 0.325f), PointF(SWidth * 0.41f, SHeight * 0.325f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.305f, SHeight * 0.325f), PointF(SWidth * 0.32f, SHeight * 0.325f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    val TE_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.85f, SHeight * 0.4f), PointF(SWidth * 0.7f, SHeight * 0.45f), BE_Middle_Sm, TE_Addi_Sm, defaultCurveTools, 30)
    val TE_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.55f, SHeight * 0.4f), PointF(SWidth * 0.15f, SHeight * 0.4f), BE_Middle_Cap, TE_Addi_Cap, defaultCurveTools, 80)

    // _________________________________________________________________________________________
    // 5. Se : derived from BE

    private val SE_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.81f, SHeight * 0.325f), PointF(SWidth * 0.825f, SHeight * 0.325f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.72f, SHeight * 0.325f), PointF(SWidth * 0.735f, SHeight * 0.325f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.765f, SHeight * 0.275f), PointF(SWidth * 0.78f, SHeight * 0.275f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val SE_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.395f, SHeight * 0.325f), PointF(SWidth * 0.41f, SHeight * 0.325f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.305f, SHeight * 0.325f), PointF(SWidth * 0.32f, SHeight * 0.325f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.35f, SHeight * 0.275f), PointF(SWidth * 0.365f, SHeight * 0.275f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    val SE_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.85f, SHeight * 0.4f), PointF(SWidth * 0.7f, SHeight * 0.45f), BE_Middle_Sm, SE_Addi_Sm, defaultCurveTools, 30)
    val SE_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.55f, SHeight * 0.4f), PointF(SWidth * 0.15f, SHeight * 0.4f), BE_Middle_Cap, SE_Addi_Cap, defaultCurveTools, 80)

    // _________________________________________________________________________________________
    // 6. jim :

    private val Jim_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(SWidth * 0.825f, SHeight * 0.28f), PointF(SWidth * 0.9f, SHeight * 0.35f), PointF(SWidth * 0.6f, SHeight * 0.35f)),
        arrayListOf(CurveTools(65), CurveTools(-20), defaultCurveTools, defaultCurveTools)
    )
    private val Jim_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(SWidth * 0.35f, SHeight * 0.28f), PointF(SWidth * 0.425f, SHeight * 0.35f), PointF(SWidth * 0.15f, SHeight * 0.5f), PointF(SWidth * 0.425f, SHeight * 0.6f), PointF(SWidth * 0.15f, SHeight * 0.5f)),
        arrayListOf(CurveTools(65), CurveTools(-25), CurveTools(-200), CurveTools(-200), CurveTools(200), CurveTools(200))
    )
    private val Jim_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.75f, SHeight * 0.44f), PointF(SWidth * 0.765f, SHeight * 0.44f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val Jim_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.37f, SHeight * 0.5f), PointF(SWidth * 0.385f, SHeight * 0.5f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    val JIM_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.7f, SHeight * 0.28f), PointF(SWidth * 0.9f, SHeight * 0.35f), Jim_Middle_Sm, Jim_Addi_Sm, defaultCurveTools, 70)
    val JIM_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.225f, SHeight * 0.28f), PointF(SWidth * 0.425f, SHeight * 0.35f), Jim_Middle_Cap, Jim_Addi_Cap, defaultCurveTools, 120)

    // _________________________________________________________________________________________
    // 7. Che : derived from Jim

    private val Che_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.795f, SHeight * 0.425f), PointF(SWidth * 0.81f, SHeight * 0.425f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.705f, SHeight * 0.425f), PointF(SWidth * 0.72f, SHeight * 0.425f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.75f, SHeight * 0.475f), PointF(SWidth * 0.765f, SHeight * 0.475f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val Che_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.415f, SHeight * 0.475f), PointF(SWidth * 0.43f, SHeight * 0.475f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.325f, SHeight * 0.475f), PointF(SWidth * 0.340f, SHeight * 0.475f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.37f, SHeight * 0.525f), PointF(SWidth * 0.385f, SHeight * 0.525f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    val Che_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.7f, SHeight * 0.28f), PointF(SWidth * 0.9f, SHeight * 0.35f), Jim_Middle_Sm, Che_Addi_Sm, defaultCurveTools, 70)
    val Che_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.225f, SHeight * 0.28f), PointF(SWidth * 0.425f, SHeight * 0.35f), Jim_Middle_Cap, Che_Addi_Cap, defaultCurveTools, 120)

    // _________________________________________________________________________________________
    // 8. he: derived from Jim

    val HE_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.7f, SHeight * 0.28f), PointF(SWidth * 0.9f, SHeight * 0.35f), Jim_Middle_Sm, defaultAdditional, defaultCurveTools, 70)
    val HE_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.225f, SHeight * 0.28f), PointF(SWidth * 0.425f, SHeight * 0.35f), Jim_Middle_Cap, defaultAdditional, defaultCurveTools, 120)

    // _________________________________________________________________________________________
    // 9. khe : derived form Jim

    private val Khe_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.775f, SHeight * 0.185f), PointF(SWidth * 0.79f, SHeight * 0.185f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val Khe_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.32f, SHeight * 0.185f), PointF(SWidth * 0.335f, SHeight * 0.185f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    val KHE_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.7f, SHeight * 0.28f), PointF(SWidth * 0.9f, SHeight * 0.35f), Jim_Middle_Sm, Khe_Addi_Sm, defaultCurveTools, 70)
    val KHE_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.225f, SHeight * 0.28f), PointF(SWidth * 0.425f, SHeight * 0.35f), Jim_Middle_Cap, Khe_Addi_Cap, defaultCurveTools, 120)

    // _________________________________________________________________________________________
    // 10. dal :

    private val DAL_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(SWidth * 0.65f, SHeight * 0.5f)),
        arrayListOf(CurveTools(550), CurveTools(-550))
    )
    private val DAL_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(SWidth * 0.225f, SHeight * 0.5f)),
        arrayListOf(CurveTools(550), CurveTools(-550))
    )

    val DAL_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.65f, SHeight * 0.33f), PointF(SWidth * 0.65f, SHeight * 0.33f), DAL_Middle_Sm, defaultAdditional, defaultCurveTools, 95)
    val DAL_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.225f, SHeight * 0.33f), PointF(SWidth * 0.225f, SHeight * 0.33f), DAL_Middle_Cap, defaultAdditional, defaultCurveTools, 95)

    // _________________________________________________________________________________________
    // 11. zal : derived from dal

    private val Zal_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.75f, SHeight * 0.225f), PointF(SWidth * 0.765f, SHeight * 0.225f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val Zal_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.325f, SHeight * 0.225f), PointF(SWidth * 0.34f, SHeight * 0.225f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    val ZAL_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.65f, SHeight * 0.33f), PointF(SWidth * 0.65f, SHeight * 0.33f), DAL_Middle_Sm, Zal_Addi_Sm, defaultCurveTools, 95)
    val ZAL_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.225f, SHeight * 0.33f), PointF(SWidth * 0.225f, SHeight * 0.33f), DAL_Middle_Cap, Zal_Addi_Cap, defaultCurveTools, 95)

    // _________________________________________________________________________________________
    // 12. re :

    val RE_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.8f, SHeight * 0.35f), PointF(SWidth * 0.6f, SHeight * 0.525f), defaultMiddlePoint, defaultAdditional, CurveTools(150), 75)
    val RE_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.35f, SHeight * 0.35f), PointF(SWidth * 0.15f, SHeight * 0.525f), defaultMiddlePoint, defaultAdditional, CurveTools(150), 75)

    // _________________________________________________________________________________________
    // 13. ze : derived from re

    private val Ze_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.795f, SHeight * 0.25f), PointF(SWidth * 0.805f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val Ze_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.345f, SHeight * 0.25f), PointF(SWidth * 0.355f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    val ZE_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.8f, SHeight * 0.35f), PointF(SWidth * 0.6f, SHeight * 0.525f), defaultMiddlePoint, Ze_Addi_Sm, CurveTools(150), 75)
    val ZE_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.35f, SHeight * 0.35f), PointF(SWidth * 0.15f, SHeight * 0.525f), defaultMiddlePoint, Ze_Addi_Cap, CurveTools(150), 75)

    // _________________________________________________________________________________________
    // 14. zhe : derived from re

    private val Zhe_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.84f, SHeight * 0.25f), PointF(SWidth * 0.85f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.75f, SHeight * 0.25f), PointF(SWidth * 0.76f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.795f, SHeight * 0.2f), PointF(SWidth * 0.805f, SHeight * 0.2f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)

    )
    private val Zhe_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.39f, SHeight * 0.25f), PointF(SWidth * 0.4f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.3f, SHeight * 0.25f), PointF(SWidth * 0.31f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.345f, SHeight * 0.2f), PointF(SWidth * 0.355f, SHeight * 0.2f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    val ZHE_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.8f, SHeight * 0.35f), PointF(SWidth * 0.6f, SHeight * 0.525f), defaultMiddlePoint, Zhe_Addi_Sm, CurveTools(150), 75)
    val ZHE_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.35f, SHeight * 0.35f), PointF(SWidth * 0.15f, SHeight * 0.525f), defaultMiddlePoint, Zhe_Addi_Cap, CurveTools(150), 75)

    // _________________________________________________________________________________________
    // 15. sin :

    private val curve = CurveTools(50, 80)
    private val curveRevs = CurveTools(50, 20)
    private val capCurve = CurveTools(150, 75)
    private val capCurveRevs = CurveTools(150, 25)
    private val Sin_Middle_Sm = MiddlePointTools(
        arrayListOf(
            PointF(SWidth * 0.85f, SHeight * 0.425f),
            PointF(SWidth * 0.8f, SHeight * 0.365f),
            PointF(SWidth * 0.75f, SHeight * 0.425f),
            PointF(SWidth * 0.7f, SHeight * 0.365f),
            PointF(SWidth * 0.65f, SHeight * 0.425f),
            PointF(SWidth * 0.625f, SHeight * 0.425f),
            PointF(SWidth * 0.65f, SHeight * 0.425f),
            PointF(SWidth * 0.7f, SHeight * 0.365f),
            PointF(SWidth * 0.65f, SHeight * 0.425f),
            PointF(SWidth * 0.625f, SHeight * 0.425f),
            PointF(SWidth * 0.65f, SHeight * 0.425f)
        ),
        arrayListOf(curve, curveRevs, curve, curveRevs, curve, defaultCurveTools, defaultCurveTools, CurveTools(-50, 20), curve, defaultCurveTools, defaultCurveTools, CurveTools(-50, 20))
    )
    private val Sin_Middle_Cap = MiddlePointTools(
        arrayListOf(
            PointF(SWidth * 0.50f, SHeight * 0.425f),
            PointF(SWidth * 0.45f, SHeight * 0.365f),
            PointF(SWidth * 0.4f, SHeight * 0.425f),
            PointF(SWidth * 0.35f, SHeight * 0.365f),
            PointF(SWidth * 0.2f, SHeight * 0.525f),
            PointF(SWidth * 0.05f, SHeight * 0.365f),
            PointF(SWidth * 0.2f, SHeight * 0.525f),
            PointF(SWidth * 0.35f, SHeight * 0.365f),
            PointF(SWidth * 0.2f, SHeight * 0.525f)
        ),
        arrayListOf(curve, curveRevs, curve, curveRevs, capCurve, capCurveRevs, CurveTools(-150, 75), CurveTools(-150, 25), capCurve, capCurveRevs)
    )

    val SIN_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.9f, SHeight * 0.365f), PointF(SWidth * 0.7f, SHeight * 0.365f), Sin_Middle_Sm, defaultAdditional, defaultCurveTools, 120)
    val SIN_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.55f, SHeight * 0.365f), PointF(SWidth * 0.05f, SHeight * 0.365f), Sin_Middle_Cap, defaultAdditional, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 16. shin : Derived from sin

    private val Shin_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.84f, SHeight * 0.25f), PointF(SWidth * 0.85f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.75f, SHeight * 0.25f), PointF(SWidth * 0.76f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.795f, SHeight * 0.2f), PointF(SWidth * 0.805f, SHeight * 0.2f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)

    )
    private val Shin_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.49f, SHeight * 0.25f), PointF(SWidth * 0.5f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.4f, SHeight * 0.25f), PointF(SWidth * 0.41f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(SWidth * 0.445f, SHeight * 0.2f), PointF(SWidth * 0.455f, SHeight * 0.2f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    val SHIN_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.9f, SHeight * 0.365f), PointF(SWidth * 0.7f, SHeight * 0.365f), Sin_Middle_Sm, Shin_Addi_Sm, defaultCurveTools, 120)
    val SHIN_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.55f, SHeight * 0.365f), PointF(SWidth * 0.05f, SHeight * 0.365f), Sin_Middle_Cap, Shin_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 17. sad :

    private val Sad_Middle_Sm = MiddlePointTools(
        arrayListOf(
            PointF(SWidth * 0.85f, SHeight * 0.365f),
            PointF(SWidth * 0.95f, SHeight * 0.395f),
            PointF(SWidth * 0.85f, SHeight * 0.425f),
            PointF(SWidth * 0.75f, SHeight * 0.425f),
            PointF(SWidth * 0.675f, SHeight * 0.365f),
            PointF(SWidth * 0.6f, SHeight * 0.425f),
            PointF(SWidth * 0.6f, SHeight * 0.425f),
            PointF(SWidth * 0.6f, SHeight * 0.425f),
            PointF(SWidth * 0.675f, SHeight * 0.365f),
            PointF(SWidth * 0.75f, SHeight * 0.425f),
            PointF(SWidth * 0.85f, SHeight * 0.425f),
            PointF(SWidth * 0.75f, SHeight * 0.425f),
            PointF(SWidth * 0.675f, SHeight * 0.365f),
            PointF(SWidth * 0.6f, SHeight * 0.425f),
            PointF(SWidth * 0.6f, SHeight * 0.425f),
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
            PointF(SWidth * 0.425f, SHeight * 0.365f),
            PointF(SWidth * 0.525f, SHeight * 0.395f),
            PointF(SWidth * 0.425f, SHeight * 0.425f),
            PointF(SWidth * 0.325f, SHeight * 0.425f),
            PointF(SWidth * 0.275f, SHeight * 0.425f),
            PointF(SWidth * 0.15f, SHeight * 0.545f),
            PointF(SWidth * 0.025f, SHeight * 0.425f),
            PointF(SWidth * 0.15f, SHeight * 0.545f),
            PointF(SWidth * 0.275f, SHeight * 0.425f)
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

    val SAD_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.75f, SHeight * 0.425f), PointF(SWidth * 0.6f, SHeight * 0.425f), Sad_Middle_Sm, defaultAdditional, defaultCurveTools, 120)
    val SAD_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.325f, SHeight * 0.425f), PointF(SWidth * 0.15f, SHeight * 0.545f), Sad_Middle_Cap, defaultAdditional, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 18 . ZAD : derived from Sad

    private val Zad_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.85f, SHeight * 0.275f), PointF(SWidth * 0.86f, SHeight * 0.275f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val Zad_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.45f, SHeight * 0.275f), PointF(SWidth * 0.46f, SHeight * 0.275f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    val ZAD_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.75f, SHeight * 0.425f), PointF(SWidth * 0.6f, SHeight * 0.425f), Sad_Middle_Sm, Zad_Addi_Sm, defaultCurveTools, 120)
    val ZAD_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.325f, SHeight * 0.425f), PointF(SWidth * 0.15f, SHeight * 0.545f), Sad_Middle_Cap, Zad_Addi_Cap, defaultCurveTools, 150)

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
            PointF(SWidth * 0.75f, SHeight * 0.365f),
            PointF(SWidth * 0.85f, SHeight * 0.395f),
            PointF(SWidth * 0.75f, SHeight * 0.425f),
            PointF(SWidth * 0.65f, SHeight * 0.425f),
            PointF(SWidth * 0.55f, SHeight * 0.425f),
            PointF(SWidth * 0.65f, SHeight * 0.425f),
            PointF(SWidth * 0.55f, SHeight * 0.425f),
            PointF(SWidth * 0.65f, SHeight * 0.425f),
            PointF(SWidth * 0.55f, SHeight * 0.425f),
            PointF(SWidth * 0.65f, SHeight * 0.425f)
        ),
        Ta_Curve
    )

    private val Ta_Middle_Cap = MiddlePointTools(
        arrayListOf(
            PointF(SWidth * 0.35f, SHeight * 0.365f),
            PointF(SWidth * 0.45f, SHeight * 0.395f),
            PointF(SWidth * 0.35f, SHeight * 0.425f),
            PointF(SWidth * 0.25f, SHeight * 0.425f),
            PointF(SWidth * 0.15f, SHeight * 0.425f),
            PointF(SWidth * 0.25f, SHeight * 0.425f),
            PointF(SWidth * 0.15f, SHeight * 0.425f),
            PointF(SWidth * 0.25f, SHeight * 0.425f),
            PointF(SWidth * 0.15f, SHeight * 0.425f),
            PointF(SWidth * 0.25f, SHeight * 0.425f)
        ),
        Ta_Curve
    )

    private val Ta_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.65f, SHeight * 0.425f), PointF(SWidth * 0.65f, SHeight * 0.275f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 20)
    )
    private val Ta_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.25f, SHeight * 0.425f), PointF(SWidth * 0.25f, SHeight * 0.275f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 20)
    )
    val TA_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.65f, SHeight * 0.425f), PointF(SWidth * 0.55f, SHeight * 0.425f), Ta_Middle_Sm, Ta_Addi_Sm, defaultCurveTools, 150)
    val TA_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.25f, SHeight * 0.425f), PointF(SWidth * 0.15f, SHeight * 0.425f), Ta_Middle_Cap, Ta_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 20. ZA : derived from TA

    private val Za_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.65f, SHeight * 0.425f), PointF(SWidth * 0.65f, SHeight * 0.275f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 20),
        SkeletonShape(PointF(SWidth * 0.795f, SHeight * 0.25f), PointF(SWidth * 0.805f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val Za_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(SWidth * 0.25f, SHeight * 0.425f), PointF(SWidth * 0.25f, SHeight * 0.275f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 20),
        SkeletonShape(PointF(SWidth * 0.385f, SHeight * 0.25f), PointF(SWidth * 0.395f, SHeight * 0.25f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )

    val ZA_Skeleton_Sm = SkeletonShape(PointF(SWidth * 0.65f, SHeight * 0.425f), PointF(SWidth * 0.55f, SHeight * 0.425f), Ta_Middle_Sm, Za_Addi_Sm, defaultCurveTools, 150)
    val ZA_Skeleton_Cap = SkeletonShape(PointF(SWidth * 0.25f, SHeight * 0.425f), PointF(SWidth * 0.15f, SHeight * 0.425f), Ta_Middle_Cap, Za_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 21. EYN :

    //    private val middleCurveEyn = MiddlePointTools(
//        arrayListOf(PointF(450f, 1100f) , PointF(300f ,750f)),
//        arrayListOf(CurveTools(-450 , 50) ,CurveTools(450 , 50) ,CurveTools(-450 , 50))
//    )
    private val Eyn_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(850f, 750f), PointF(625f, 750f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 30)
    )
    private var Eyn_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(400f, 750f), PointF(300f, 750f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 35),
        SkeletonShape(PointF(300f, 750f), PointF(300f, 1100f), defaultMiddlePoint, defaultAdditional, CurveTools(-300, 75), 50),
        SkeletonShape(PointF(300f, 1100f), PointF(450f, 1075f), defaultMiddlePoint, defaultAdditional, CurveTools(-30), 50),
    )

    val EYN_Skeleton_Sm = SkeletonShape(PointF(850f, 600f), PointF(750f, 750f), defaultMiddlePoint, Eyn_Addi_Sm, CurveTools(-150, 40), 50)
    val EYN_Skeleton_Cap = SkeletonShape(PointF(400f, 600f), PointF(300f, 750f), defaultMiddlePoint, Eyn_Addi_Cap, CurveTools(-150, 40), 50)

    // _________________________________________________________________________________________
    // 22.GHYN : derived from EYN

    private val Ghyn_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(850f, 750f), PointF(625f, 750f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 30)

    )
    private var Ghyn_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(400f, 750f), PointF(300f, 750f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 100),
        SkeletonShape(PointF(300f, 750f), PointF(300f, 1100f), defaultMiddlePoint, defaultAdditional, CurveTools(-300, 75), 100),
        SkeletonShape(PointF(300f, 1100f), PointF(450f, 1075f), defaultMiddlePoint, defaultAdditional, CurveTools(-30), 100)

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
        SkeletonShape(PointF(825f, 500f), PointF(840f, 500f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val Fe_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(525f, 500f), PointF(540f, 500f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
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
        SkeletonShape(PointF(900f, 500f), PointF(885f, 500f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(800f, 500f), PointF(785f, 500f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
    )
    private val Qaf_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(550f, 500f), PointF(535f, 500f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(450f, 500f), PointF(435f, 500f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
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
        SkeletonShape(PointF(850f, 525f), PointF(1000f, 300f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 50),
    )
    private val Kaf_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(550f, 525f), PointF(800f, 300f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 50),
    )

    val KAF_Skeleton_Sm = SkeletonShape(PointF(850f, 550f), PointF(750f, 950f), Kaf_Middle_Sm, Kaf_Addi_Sm, defaultCurveTools, 100)
    val KAF_Skeleton_Cap = SkeletonShape(PointF(550f, 550f), PointF(500f, 950f), Kaf_Middle_Cap, Kaf_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 26. GAF : derived from KAF

    private val Gaf_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(850f, 525f), PointF(1000f, 300f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 50),
        SkeletonShape(PointF(850f, 375f), PointF(1000f, 150f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 50)
    )
    private val Gaf_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(550f, 525f), PointF(800f, 300f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 50),
        SkeletonShape(PointF(550f, 375f), PointF(800f, 150f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 50),
    )

    val GAF_Skeleton_Sm = SkeletonShape(PointF(850f, 550f), PointF(750f, 950f), Kaf_Middle_Sm, Gaf_Addi_Sm, defaultCurveTools, 100)
    val GAF_Skeleton_Cap = SkeletonShape(PointF(550f, 550f), PointF(500f, 950f), Kaf_Middle_Cap, Gaf_Addi_Cap, defaultCurveTools, 150)

    // _________________________________________________________________________________________
    // 27 . LAM :

    private val Lam_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(500f, 850f), PointF(350f, 1100f), defaultMiddlePoint, defaultAdditional, CurveTools(150, 75), 40),
        SkeletonShape(PointF(350f, 1100f), PointF(200f, 850f), defaultMiddlePoint, defaultAdditional, CurveTools(150, 25), 40),
    )

    val LAM_Skeleton_Sm = SkeletonShape(PointF(850f, 550f), PointF(750f, 950f), Kaf_Middle_Sm, defaultAdditional, defaultCurveTools, 100)
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

    val MIM_Skeleton_Sm = SkeletonShape(PointF(850f, 650f), PointF(600f, 650f), Mim_Middle_Sm, defaultAdditional, defaultCurveTools, 100)
    val MIM_Skeleton_Cap = SkeletonShape(PointF(450f, 650f), PointF(200f, 675f), Mim_Middle_Cap, defaultAdditional, defaultCurveTools, 100)

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
        SkeletonShape(PointF(800f, 550f), PointF(815f, 550f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val Noon_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(400f, 600f), PointF(415f, 600f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
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

    val VAV_Skeleton_Sm = SkeletonShape(PointF(850f, 650f), PointF(625f, 950f), Vav_middle_Sm, defaultAdditional, defaultCurveTools, 100)
    val VAV_Skeleton_Cap = SkeletonShape(PointF(450f, 650f), PointF(225f, 950f), Vav_middle_Cap, defaultAdditional, defaultCurveTools, 100)

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
        SkeletonShape(PointF(835f, 715f), PointF(690f, 835f), defaultMiddlePoint, defaultAdditional, CurveTools(20), 25),
        SkeletonShape(PointF(655f, 850f), PointF(575f, 850f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 10)
    )

    val HEdo_Skeleton_Sm = SkeletonShape(PointF(750f, 650f), PointF(675f, 850f), HEdo_Middle_Sm, HEdo_Addi_Sm, defaultCurveTools, 100)
    val HEdo_Skeleton_Cap = SkeletonShape(PointF(425f, 850f), PointF(325f, 625f), HEdo_Middle_Cap, defaultAdditional, defaultCurveTools, 100)

    // _________________________________________________________________________________________
    // 32 . YE : derived from Noon

    private val Ye_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(800f, 900f), PointF(785f, 900f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2),
        SkeletonShape(PointF(850f, 900f), PointF(865f, 900f), defaultMiddlePoint, defaultAdditional, defaultCurveTools, 2)
    )
    private val Ye_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(400f, 800f), PointF(525f, 900f), PointF(400f, 1100f), PointF(200f, 750f), PointF(400f, 1100f), PointF(525f, 900f), PointF(400f, 1100f)),
        arrayListOf(CurveTools(-75), CurveTools(-50, 25), CurveTools(100, 40), CurveTools(400), CurveTools(-400), CurveTools(-100, 60), CurveTools(100, 40), CurveTools(400))
    )

    val YE_Skeleton_Sm = SkeletonShape(PointF(900f, 650f), PointF(750f, 750f), Noon_Middle_Sm, Ye_Addi_Sm, defaultCurveTools, 50)
    val YE_Skeleton_Cap = SkeletonShape(PointF(550f, 700f), PointF(200f, 750f), Ye_Middle_Cap, defaultAdditional, defaultCurveTools, 175)

    // _________________________________________________________________________________________


}

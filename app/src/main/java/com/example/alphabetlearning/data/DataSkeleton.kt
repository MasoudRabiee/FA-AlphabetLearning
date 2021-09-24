package com.example.alphabetlearning.data

import android.graphics.Point
import android.graphics.PointF
import com.example.alphabetlearning.model.*

object DataSkeleton {
    // Default Properties :
    private val defaultCurveTools = CurveTools()


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
    // Che :

    // he:

    // khe :

    // dal :
//    private val SE_Addi_Sm = arrayListOf(
//        SkeletonShape(PointF(895f,450f) , PointF(885f,450f) , 2) ,
//        SkeletonShape(PointF(815f,450f) , PointF(825f,450f) , 2) ,
//        SkeletonShape(PointF(850f,400f) , PointF(860f,400f) , 2)
//    )
//
//    private val SE_Addi_Cap = arrayListOf<SkeletonShape>(
//        SkeletonShape(PointF(440f , 450f) , PointF(450f , 450f), 2) ,
//        SkeletonShape(PointF(360f , 450f) , PointF(370f , 450f), 2) ,
//        SkeletonShape(PointF(400f , 400f) , PointF(410f , 400f), 2)
//    )
//    val SE_Skeleton_Sm = SkeletonShape(PointF(900f , 500f) , PointF(800f ,550f) , BE_Middle_Sm , SE_Addi_Sm)
//    val SE_Skeleton_Cap = SkeletonShape(PointF(550f , 500f) , PointF(250f,500f) , BE_Middle_Cap , SE_Addi_Cap)
}
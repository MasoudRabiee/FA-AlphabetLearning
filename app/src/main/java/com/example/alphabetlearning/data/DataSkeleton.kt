package com.example.alphabetlearning.data

import android.graphics.PointF
import com.example.alphabetlearning.model.*

object DataSkeleton {
    // Default Properties :
    private val defaultCurveTools = CurveTools()

    //  ALEF :
    private val ALEF_Middle = MiddlePointTools(null,null)
    private val ALEF_Mid_Addi = MiddlePointTools(
        arrayListOf(PointF(875f , 150f) , PointF(725f, 150f)),
        arrayListOf(CurveTools(25) , defaultCurveTools , CurveTools(-25))
    )
    private val ALEF_Additional = arrayListOf<SkeletonShape>(
        SkeletonShape(PointF(900f , 125f) , PointF(700f , 175f) , ALEF_Mid_Addi , defaultCurveTools)
    )
    val ALEF_Skeleton_Cap = SkeletonShape(PointF(300f , 300f) , PointF(300f ,700f) , defaultCurveTools)
    val ALEF_Skeleton_Sm = SkeletonShape(PointF(800f , 300f) , PointF(800f,700f) , ALEF_Middle , ALEF_Additional , defaultCurveTools)


    //    private val ALEF_Middle = arrayListOf<PointF>()
//    private val ALEF_Mid_Addi = arrayListOf<PointF>(
//        PointF(900f , 150f) , PointF(700f, 150f)
//    )
//    private val ALEF_Additional = arrayListOf<SkeletonShape>(
//        SkeletonShape(PointF(900f , 125f) , PointF(700f , 175f) , ALEF_Mid_Addi)
//    )
//    val ALEF_Skeleton_Cap = SkeletonShape(PointF(300f , 300f) , PointF(300f ,700f))
//    val ALEF_Skeleton_Sm = SkeletonShape(PointF(800f , 300f) , PointF(800f,700f) , ALEF_Middle , ALEF_Additional)
//
//    // Be :
    private val BE_Middle_Sm = MiddlePointTools(
        arrayListOf(PointF(850f , 550f)),
        arrayListOf(CurveTools(50) , defaultCurveTools)
    )
    private val BE_Addi_Sm = arrayListOf(
        SkeletonShape(PointF(850f,650f) , PointF(860f,650f) , defaultCurveTools , 2)
    )
    private val BE_Middle_Cap = MiddlePointTools(
        arrayListOf(PointF(500f , 550f) , PointF(300f, 550f)),
        arrayListOf(CurveTools(50) , defaultCurveTools , CurveTools(50))
    )
    private val BE_Addi_Cap = arrayListOf(
        SkeletonShape(PointF(400f , 650f) , PointF(410f , 650f), defaultCurveTools , 2)
    )
    val BE_Skeleton_Sm = SkeletonShape(PointF(900f , 500f) , PointF(800f ,550f) , BE_Middle_Sm , BE_Addi_Sm , defaultCurveTools)
    val BE_Skeleton_Cap = SkeletonShape(PointF(550f , 500f) , PointF(250f,500f) , BE_Middle_Cap , BE_Addi_Cap , defaultCurveTools)
//
//    // Pe : az Be greftam
//    private val PE_Addi_Sm = arrayListOf(
//        SkeletonShape(PointF(895f,650f) , PointF(885f,650f) , 2) ,
//        SkeletonShape(PointF(815f,650f) , PointF(825f,650f) , 2) ,
//        SkeletonShape(PointF(850f,700f) , PointF(860f,700f) , 2)
//    )
//
//    private val PE_Addi_Cap = arrayListOf<SkeletonShape>(
//        SkeletonShape(PointF(440f , 650f) , PointF(450f , 650f), 2) ,
//        SkeletonShape(PointF(360f , 650f) , PointF(370f , 650f), 2) ,
//        SkeletonShape(PointF(400f , 700f) , PointF(410f , 700f), 2)
//    )
//    val PE_Skeleton_Sm = SkeletonShape(PointF(900f , 500f) , PointF(800f ,550f) , BE_Middle_Sm , PE_Addi_Sm)
//    val PE_Skeleton_Cap = SkeletonShape(PointF(550f , 500f) , PointF(250f,500f) , BE_Middle_Cap , PE_Addi_Cap)
//
//    // Te : az Be greftam
//    private val TE_Addi_Sm = arrayListOf(
//        SkeletonShape(PointF(895f,450f) , PointF(885f,450f) , 2) ,
//        SkeletonShape(PointF(815f,450f) , PointF(825f,450f) , 2)
//    )
//
//    private val TE_Addi_Cap = arrayListOf<SkeletonShape>(
//        SkeletonShape(PointF(440f , 450f) , PointF(450f , 450f), 2) ,
//        SkeletonShape(PointF(360f , 450f) , PointF(370f , 450f), 2)
//    )
//    val TE_Skeleton_Sm = SkeletonShape(PointF(900f , 500f) , PointF(800f ,550f) , BE_Middle_Sm , TE_Addi_Sm)
//    val TE_Skeleton_Cap = SkeletonShape(PointF(550f , 500f) , PointF(250f,500f) , BE_Middle_Cap , TE_Addi_Cap)
//
//    // Se : az Be greftam :
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

    // jim :

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
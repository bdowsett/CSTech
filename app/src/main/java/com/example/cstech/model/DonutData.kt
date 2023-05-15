package com.example.cstech.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.RawValue


data class DonutData(
    val accountIDVStatus: String,
    val creditReportInfo: CreditReportInfo,
    val dashboardStatus: String,
    val personaType: String,
    val coachingSummary: CoachingSummary,
    val augmentedCreditScore: Long? = null,
)

data class CoachingSummary(
    val activeTodo: Boolean,
    val activeChat: Boolean,
    val numberOfTodoItems: Long,
    val numberOfCompletedTodoItems: Long,
    //val selected: Boolean,
)

@Parcelize
data class CreditReportInfo(
    val score: Long,
    val scoreBand: Long,
    val clientRef: String,
    val status: String,
    val maxScoreValue: Long,
    val minScoreValue: Long,
    val monthsSinceLastDefaulted: Long,
    val hasEverDefaulted: Boolean,
    val monthsSinceLastDelinquent: Long,
    val hasEverBeenDelinquent: Boolean,
    val percentageCreditUsed: Long,
    val percentageCreditUsedDirectionFlag: Long,
    val changedScore: Long,
    val currentShortTermDebt: Long,
    val currentShortTermNonPromotionalDebt: Long,
    //val currentShortTermCreditLimit: Long,
    val currentShortTermCreditUtilisation: Long,
    val changeInShortTermDebt: Long,
    val currentLongTermDebt: Long,
    val currentLongTermNonPromotionalDebt: Long,
    val currentLongTermCreditLimit: Long? = null,
    val currentLongTermCreditUtilisation: Long? = null,
    val changeInLongTermDebt: Long,
    val numPositiveScoreFactors: Long,
    val numNegativeScoreFactors: Long,
    val equifaxScoreBand: Long,
    val equifaxScoreBandDescription: String,
    val daysUntilNextReport: Long,
): Parcelable

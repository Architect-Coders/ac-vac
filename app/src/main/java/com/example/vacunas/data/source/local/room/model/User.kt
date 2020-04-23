package com.example.vacunas.data.source.local.room.model

import androidx.room.*
import com.example.domain.BloodType
import com.example.domain.BloodType.Companion.CONST_AB_NEG
import com.example.domain.BloodType.Companion.CONST_AB_POS
import com.example.domain.BloodType.Companion.CONST_A_NEG
import com.example.domain.BloodType.Companion.CONST_A_POS
import com.example.domain.BloodType.Companion.CONST_B_NEG
import com.example.domain.BloodType.Companion.CONST_B_POS
import com.example.domain.BloodType.Companion.CONST_ZERO_NEG
import com.example.domain.BloodType.Companion.CONST_ZERO_POS
import com.example.domain.SpainRegion
import com.example.domain.SpainRegion.Companion.CONST_ANDALUCIA
import com.example.domain.SpainRegion.Companion.CONST_ARAGON
import com.example.domain.SpainRegion.Companion.CONST_ASTURIAS
import com.example.domain.SpainRegion.Companion.CONST_CANTABRIA
import com.example.domain.User as DomainUser

@Entity(tableName = "users")
data class User(
    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "birthdate")
    val birthDate: Long = -1L,

    @ColumnInfo(name = "bloodType")
    @TypeConverters(Converters::class)
    val bloodType: BloodType = BloodType.UNKNOWN,

    @ColumnInfo(name = "region")
    @TypeConverters(Converters::class)
    val region: SpainRegion = SpainRegion.UNKNOWN
) {
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0

    class Converters {
        @TypeConverter
        fun toSpainRegion(spainRegion: String): SpainRegion = when (spainRegion) {
            CONST_ANDALUCIA -> SpainRegion.ANDALUCIA
            CONST_ARAGON -> SpainRegion.ARAGON
            CONST_ASTURIAS -> SpainRegion.ASTURIAS
            CONST_CANTABRIA -> SpainRegion.CANTABRIA
            else -> SpainRegion.UNKNOWN
        }

        @TypeConverter
        fun fromSpainRegion(spainRegion: SpainRegion): String = spainRegion.refValue

        @TypeConverter
        fun toBloodType(bloodType: Int): BloodType {
            return when (bloodType) {
                CONST_A_POS -> BloodType.A_POS
                CONST_A_NEG -> BloodType.A_NEG
                CONST_B_POS -> BloodType.B_POS
                CONST_B_NEG -> BloodType.B_NEG
                CONST_AB_POS -> BloodType.AB_POS
                CONST_AB_NEG -> BloodType.AB_NEG
                CONST_ZERO_POS -> BloodType.ZERO_POS
                CONST_ZERO_NEG -> BloodType.ZERO_NEG
                else -> BloodType.UNKNOWN
            }
        }

        @TypeConverter
        fun fromBloodType(bloodType: BloodType): Int = bloodType.refValue
    }
}

fun DomainUser.toRoomUser(): User = User(
    name, birthDate, bloodType, region
)

fun User.toDomainUser(): DomainUser = DomainUser(
    name, birthDate, bloodType, region
)
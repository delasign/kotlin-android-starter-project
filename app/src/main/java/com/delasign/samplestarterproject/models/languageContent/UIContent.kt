package com.delasign.samplestarterproject.models.languageContent

data class UIContent(
    val sample: Sample,
    val sampleTwo: SampleTwo,
) {
    data class Sample(
        val sampleString: String,
    )

    data class SampleTwo(
        val sampleA: SampleSecondTierStructure,
        val sampleB: ASecondSampleSecondTierStructure,
    ) {
        data class SampleSecondTierStructure(
            val sampleString: String,
            val sampleStringTwo: String,
        )

        data class ASecondSampleSecondTierStructure(
            val aSampleString: String,
            val aSampleStringTwo: String,
        )
    }
}

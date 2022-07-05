package furhatos.app.socialrobot.nlu

import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.util.Language

// Our Emotions entity.
class Emotions : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("happy", "sad", "angry", "good", "bad")
    }
}

// Our TalkAboutFeelings intent
class TalkAboutFeelings(val emotion : Emotions? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@emotion", "I feel happy", "I'm sad", "I'm feeling @emotion")
    }
}
package com.example.learnical.core

import com.atilika.kuromoji.ipadic.Tokenizer
import com.moji4j.MojiConverter
import org.apache.commons.lang3.StringUtils
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	val lyrics = """
		ليلى سيدا الملحق الفرعي
		مرحبا، مع السلامة، ماذا؟
		ليلى سيدا الملحق الفرعي
		مرحبا، مع السلامة، ماذا؟
		立ちはだかるボスをまだ 起こさずに
		崩れてく 摩天楼を眺め
		砂ぼこりは今日も 君の頬 汚してる
		躊躇いもなく あぁ
		そばにいたい訳を 記すなら
		都合のいい 名前を付けるが
		属することないよ 前提が いないから
		瞼も使わず
		青いタネを 潰しては口に運んでく
		夕暮れまで 永遠などないと
		知らしめるから
		きっと水でさえ この熱でさえ
		感じていないのなら 使い切って声に出そう
		通えない記憶を全部
		冷凍したって形に残るんだ
		こんな気持ちだけ 名前があるだけ
		手を握るたび プログラムだってこと？
		誰にも当てはまることない
		基準なんていらないよ
		浮かんでいるだけの
		あの泡に 名前がある
		この世界には
		再現困難の 表情が 意味を持つ
		言葉も要らぬほど
		生まれて死ぬまでを 人間は
		一度しか 辿れないのなら
		何度も壊しては 組み立てて
		奇跡だとか 確かめていたいだけ
		桃味の 炭酸水に2人潜り込んで
		少し泣いても わかんない具合に
		晦ましあえた
		きっと震えさえ この重ささえ
		届かないのなら ボタン押して消去しよう
		揃わない記憶を全部
		解答したって不安を増すんだ
		そんなメモリだけ 名前があるだけ
		目を逸らしたら 錆びてしまうけれど
		遮る無駄な思考回路も
		傷になって触れたくて
		言えるかな
		言い切れること 1つもいらないよ
		偽物さえも その見解も
		誰が決めることでもないよ
		勝ち負けが白黒が人間が
		人間じゃないかなんてもう 正しさは無くて
		儚い傷も抱きしめよう 目を瞑ろう
		今日を終わらせるために
		きっと水でさえ この熱でさえ
		感じていないのなら 使い切って声に出そう
		通えない記憶を全部
		冷凍したって形に残るんだ
		こんな気持ちだけ 名前があるだけ
		手を握るたび プログラムだってこと？
		誰にも当てはまることない
		基準なんていらないよ
		ليلى سيدا الملحق الفرعي
		مرحبا، مع السلامة، ماذا؟
		ليلى سيدا الملحق الفرعي
		مرحبا، مع السلامة، ماذا؟""".trimIndent()


	val tokenizer = Tokenizer()
	val mojiConverter = MojiConverter()

	val sb = StringBuilder()
	tokenizer.tokenize(lyrics).forEach({ token ->
		sb.append(token.surface)
	})

	val diff = StringUtils.difference(sb.toString(), lyrics)
	println(StringUtils.equals(sb.toString(), lyrics))
	runApplication<DemoApplication>(*args)
}

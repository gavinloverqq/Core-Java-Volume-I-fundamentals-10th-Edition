1.不能使用 == 检测两个字符串是否相等
2. 代码点（Code Point）：在 Unicode 代码空间中的一个值，取值 0x0 至 0x10FFFF，代表一个字符。代码单元（Code Unit）：在具体编码形式中的最小单位。比如 UTF-16 中一个 code unit 为 16 bits，UTF-8 中一个 code unit 为 8 bits。一个 code point 可能由一个或多个 code unit(s) 表示。在 U+10000 之前的 code point 可以由一个 UTF-16 code unit 表示，U+10000 及之后的 code point 要由两个 UTF-16 code units 表示。
3. 
1.jQuery 库中的 $() 是什么？jQuery实现的原理是什么？
    $() 函数是 jQuery() 函数的别称。
    $() 函数用于将任何对象包裹成 jQuery 对象，接着你就被允许调用定义在 jQuery 对象上的多个不同方法。
    你可以将一个选择器字符串传入 $() 函数，它会返回一个包含所有匹配的 DOM 元素数组的 jQuery 对象。


    jq最核心的是 $ ，它是一个函数。
    函数中返回一个自定义的jq对象，它是一个类。
    在这个类的原型下面有许多jq自定义的方法，如on,css。。。
    每次调用 $ 都会返回一个新的jq对象，

    同时在 $ 函数中，根据传入参数的类型，如（#div1, .div2, span等）,函数或者字符串，
    把选中的元素存在数组中，遍历这个数组，去除每个元素进行dom操作。

    jQuery可以链式操作，是因为，在每一个方法中，都会在最后 return this
    返回了当前 $函数中的jq对象，所以就能继续链式操作了。

2. JavaScript window.onload 事件和 jQuery ready 函数有何不同？
    ready()&load().jpg

3. $(this) 和 this 关键字在 jQuery 中有何不同？请打印观察
    $(this) 返回一个 jQuery 对象，你可以对它调用多个 jQuery 方法，比如用 text() 获取文本，用val() 获取值等等。

    而 this 代表当前元素，它是 JavaScript 关键词中的一个，表示上下文中的当前 DOM 元素。你不能对它调用 jQuery 方法，直到它被
    $() 函数包裹，例如 $(this)。


4.jquery有那些类型的选择器？
    一、基本选择器
    基本选择器是jQuery中最常用也是最简单的选择器，它通过元素的id、class和标签名等来查找DOM元素。
    1、ID选择器 #id
    描述：根据给定的id匹配一个元素， 返回单个元素（注：在网页中，id名称不能重复）
    示例：$("#test") 选取 id 为 test 的元素
    2、类选择器 .class
    描述：根据给定的类名匹配元素，返回元素集合
    示例：$(".test") 选取所有class为test的元素
    3、元素(标签)选择器 element
    描述：根据给定的元素名匹配元素，返回元素集合
    示例：$("p") 选取所有的<p>元素 $("div") :选取所有的div标签
    4、*
    描述：匹配所有元素，返回元素集合
    示例：$("*") 选取所有的元素
    5、selector1，selector2,...,selectorN（并集选择器）
    描述：将每个选择器匹配到的元素合并后一起返回，返回合并后的元素集合
    示例：$("p,span,p.myClass") 选取所有<p>,<span>和class为myClass的<p>标签的元素集合
    二、层次选择器
    层次选择器根据层次关系获取特定元素。
    1、后代选择器
    示例：$("p span") 选取<p>元素里的所有的<span>元素（注：后代选择器选择父元素所有指定选择的元素，不管是儿子级，还是孙子级）
    2、子选择器 $("parent>child")
    示例：$("p>span") 选择<p>元素下的所有<span>元素 （注：子选择器只选择直属于父元素的子元素）
    3、同辈选择器 $("prev+next")
    描述：选取紧接在prev元素后的next元素，返回元素集合
    示例：$(".one+p") 选取class为one的下一个<p>同辈元素集合
    4、同辈选择器 $("prev~siblings")
    描述：选取prev元素后的所有siblings元素，返回元素集合
    示例：$("#two~p")选取id为two的元素后所有<p>同辈元素集合
    三、过滤选择器
    1>基本过滤选择器
    1、 :first
    描述：选取第一个元素，返回单个元素
    示例：$("p:first") 选取所有<p>元素中第一个<p>元素
    2、 :last
    描述：选取最后一个元素，返回单个元素
    示例：$("p:last") 选取所有<p>元素中最后一个<p>元素
    3、 :not(selector)
    描述：去除所有与给定选择器匹配的元素，返回元素集合
    示例：$("input:not(.myClass)") 选取class不是myClass的<input>元素
    4、 :even
    描述：选取索引是偶数的所有元素，索引从0开始，返回元素集合
    5、 :odd
    描述：选取索引是奇数的所有元素，索引从0开始，返回元素集合
    6、 :eq(index)
    描述：选取索引等于index的元素，索引从0开始，返回单个元素
    7、 :gt(index)
    描述：选取索引大于index的元素，索引从0开始，返回元素集合
    8、 :lt(index)
    描述：选取索引小于于index的元素，索引从0开始，返回元素集合
    9、 :focus
    描述：选取当前获取焦点的元素
    2>内容过滤选择器
    1、:contains(text)
    描述：选取含有文本内容为text的元素，返回元素集合
    示例：$("p:contains('我')") 选取含有文本“我”的元素
    2、:empty
    描述：选取不包含子元素或者文本元素的空元素，返回元素集合
    示例：$("p:empty") 选取不包含子元素或者文本元素的空<p>元素（<p></p>）
    3、:has(selector)
    描述：选取含有选择器所匹配的元素的元素，返回元素集合
    示例：$("p:has(p)") 选取含有<p>元素的<p>元素（<p><p/></p>）
    4、:parent
    描述：选取含有子元素或者文本的元素，返回元素集合
    示例：$("p:parent") 选取含有子元素或者文本元素的<p>元素（<p><p/></p>或者<p>文本</p>）
    3>可见性过滤选择器
    1、:hidden
    描述：选取所有不可见的元素，返回元素集合
    2、:visible
    描述：选取所有可见的元素，返回元素集合
    4>属性过滤选择器（返回元素集合）
    1、[attribute]
    示例：$("p[id]") 选取拥有id属性的p元素
    2、[attribute=value]
    示例：$("input[name=text]") 选取拥有name属性等于text的input元素
    3、[attribute!=value]
    示例：$("input[name!=text]") 选取拥有name属性不等于text的input元素
    4、[attribute^=value]
    示例：$("input[name^=text]") 选取拥有name属性以text开始的input元素
    5、[attribute$=value]
    示例：$("input[name$=text]") 选取拥有name属性以text结束的input元素
    6、[attribute*=value]
    示例：$("input[name*=text]") 选取拥有name属性含有text的input元素
    7、[attribute~=value]
    示例：$("input[class~=text]") 选取拥有class属性以空格分割的值中含有text的input元素
    8、[attribute1][attribute2][attributeN]
    描述：合并多个属性过滤选择器
    5>表单对象属性过滤选择器（返回元素集合）
    1、:enabled
    描述：选取所有可用元素
    2、:disabled
    描述：选取所有不可用元素
    3、:checked
    描述：选取所有被选中的元素（单选框，复选框）
    示例：$("input:checked") 选取所有被选中的<input>元素
    4、:selected
    描述：选取所有被选中的选项元素（下拉列表）
    示例：$("select option:selected") 选取所有被选中的选项元素
    四、表单选择器（返回元素集合，使用相似）
    1、:text
    描述：选择所有的单行文本框
    示例：$(":text")选取所有的单行文本框
    2、:password
    描述：选择所有的密码框
    3、:button
    描述：选择所有的按钮
    4、:checkbox
    描述：选择所有的多选框
  


5.Dom对象如何转jquery对象，jquery对象如何转Dom对象？ 
    dom -> jquery
    $(document.getElementById("jquery"))

	jquery -> dom
	    1.$("#jquery").get(0);
	    2.$("#jquery")[0]; $("div")[5];
	
6.哪种方式更高效：document.getElementbyId("myId") 还是 $("#myId")？
    第一种，因为它直接使用javascript引擎
  
7.按要求编程练习选择器
 


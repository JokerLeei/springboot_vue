1.jQuery ���е� $() ��ʲô��jQueryʵ�ֵ�ԭ����ʲô��
    $() ������ jQuery() �����ı�ơ�
    $() �������ڽ��κζ�������� jQuery ���󣬽�����ͱ��������ö����� jQuery �����ϵĶ����ͬ������
    ����Խ�һ��ѡ�����ַ������� $() ���������᷵��һ����������ƥ��� DOM Ԫ������� jQuery ����


    jq����ĵ��� $ ������һ��������
    �����з���һ���Զ����jq��������һ���ࡣ
    ��������ԭ������������jq�Զ���ķ�������on,css������
    ÿ�ε��� $ ���᷵��һ���µ�jq����

    ͬʱ�� $ �����У����ݴ�����������ͣ��磨#div1, .div2, span�ȣ�,���������ַ�����
    ��ѡ�е�Ԫ�ش��������У�����������飬ȥ��ÿ��Ԫ�ؽ���dom������

    jQuery������ʽ����������Ϊ����ÿһ�������У���������� return this
    �����˵�ǰ $�����е�jq�������Ծ��ܼ�����ʽ�����ˡ�

2. JavaScript window.onload �¼��� jQuery ready �����кβ�ͬ��
    ready()&load().jpg

3. $(this) �� this �ؼ����� jQuery ���кβ�ͬ�����ӡ�۲�
    $(this) ����һ�� jQuery ��������Զ������ö�� jQuery ������������ text() ��ȡ�ı�����val() ��ȡֵ�ȵȡ�

    �� this ������ǰԪ�أ����� JavaScript �ؼ����е�һ������ʾ�������еĵ�ǰ DOM Ԫ�ء��㲻�ܶ������� jQuery ������ֱ������
    $() �������������� $(this)��


4.jquery����Щ���͵�ѡ������
    һ������ѡ����
    ����ѡ������jQuery�����Ҳ����򵥵�ѡ��������ͨ��Ԫ�ص�id��class�ͱ�ǩ����������DOMԪ�ء�
    1��IDѡ���� #id
    ���������ݸ�����idƥ��һ��Ԫ�أ� ���ص���Ԫ�أ�ע������ҳ�У�id���Ʋ����ظ���
    ʾ����$("#test") ѡȡ id Ϊ test ��Ԫ��
    2����ѡ���� .class
    ���������ݸ���������ƥ��Ԫ�أ�����Ԫ�ؼ���
    ʾ����$(".test") ѡȡ����classΪtest��Ԫ��
    3��Ԫ��(��ǩ)ѡ���� element
    ���������ݸ�����Ԫ����ƥ��Ԫ�أ�����Ԫ�ؼ���
    ʾ����$("p") ѡȡ���е�<p>Ԫ�� $("div") :ѡȡ���е�div��ǩ
    4��*
    ������ƥ������Ԫ�أ�����Ԫ�ؼ���
    ʾ����$("*") ѡȡ���е�Ԫ��
    5��selector1��selector2,...,selectorN������ѡ������
    ��������ÿ��ѡ����ƥ�䵽��Ԫ�غϲ���һ�𷵻أ����غϲ����Ԫ�ؼ���
    ʾ����$("p,span,p.myClass") ѡȡ����<p>,<span>��classΪmyClass��<p>��ǩ��Ԫ�ؼ���
    �������ѡ����
    ���ѡ�������ݲ�ι�ϵ��ȡ�ض�Ԫ�ء�
    1�����ѡ����
    ʾ����$("p span") ѡȡ<p>Ԫ��������е�<span>Ԫ�أ�ע�����ѡ����ѡ��Ԫ������ָ��ѡ���Ԫ�أ������Ƕ��Ӽ����������Ӽ���
    2����ѡ���� $("parent>child")
    ʾ����$("p>span") ѡ��<p>Ԫ���µ�����<span>Ԫ�� ��ע����ѡ����ֻѡ��ֱ���ڸ�Ԫ�ص���Ԫ�أ�
    3��ͬ��ѡ���� $("prev+next")
    ������ѡȡ������prevԪ�غ��nextԪ�أ�����Ԫ�ؼ���
    ʾ����$(".one+p") ѡȡclassΪone����һ��<p>ͬ��Ԫ�ؼ���
    4��ͬ��ѡ���� $("prev~siblings")
    ������ѡȡprevԪ�غ������siblingsԪ�أ�����Ԫ�ؼ���
    ʾ����$("#two~p")ѡȡidΪtwo��Ԫ�غ�����<p>ͬ��Ԫ�ؼ���
    ��������ѡ����
    1>��������ѡ����
    1�� :first
    ������ѡȡ��һ��Ԫ�أ����ص���Ԫ��
    ʾ����$("p:first") ѡȡ����<p>Ԫ���е�һ��<p>Ԫ��
    2�� :last
    ������ѡȡ���һ��Ԫ�أ����ص���Ԫ��
    ʾ����$("p:last") ѡȡ����<p>Ԫ�������һ��<p>Ԫ��
    3�� :not(selector)
    ������ȥ�����������ѡ����ƥ���Ԫ�أ�����Ԫ�ؼ���
    ʾ����$("input:not(.myClass)") ѡȡclass����myClass��<input>Ԫ��
    4�� :even
    ������ѡȡ������ż��������Ԫ�أ�������0��ʼ������Ԫ�ؼ���
    5�� :odd
    ������ѡȡ����������������Ԫ�أ�������0��ʼ������Ԫ�ؼ���
    6�� :eq(index)
    ������ѡȡ��������index��Ԫ�أ�������0��ʼ�����ص���Ԫ��
    7�� :gt(index)
    ������ѡȡ��������index��Ԫ�أ�������0��ʼ������Ԫ�ؼ���
    8�� :lt(index)
    ������ѡȡ����С����index��Ԫ�أ�������0��ʼ������Ԫ�ؼ���
    9�� :focus
    ������ѡȡ��ǰ��ȡ�����Ԫ��
    2>���ݹ���ѡ����
    1��:contains(text)
    ������ѡȡ�����ı�����Ϊtext��Ԫ�أ�����Ԫ�ؼ���
    ʾ����$("p:contains('��')") ѡȡ�����ı����ҡ���Ԫ��
    2��:empty
    ������ѡȡ��������Ԫ�ػ����ı�Ԫ�صĿ�Ԫ�أ�����Ԫ�ؼ���
    ʾ����$("p:empty") ѡȡ��������Ԫ�ػ����ı�Ԫ�صĿ�<p>Ԫ�أ�<p></p>��
    3��:has(selector)
    ������ѡȡ����ѡ������ƥ���Ԫ�ص�Ԫ�أ�����Ԫ�ؼ���
    ʾ����$("p:has(p)") ѡȡ����<p>Ԫ�ص�<p>Ԫ�أ�<p><p/></p>��
    4��:parent
    ������ѡȡ������Ԫ�ػ����ı���Ԫ�أ�����Ԫ�ؼ���
    ʾ����$("p:parent") ѡȡ������Ԫ�ػ����ı�Ԫ�ص�<p>Ԫ�أ�<p><p/></p>����<p>�ı�</p>��
    3>�ɼ��Թ���ѡ����
    1��:hidden
    ������ѡȡ���в��ɼ���Ԫ�أ�����Ԫ�ؼ���
    2��:visible
    ������ѡȡ���пɼ���Ԫ�أ�����Ԫ�ؼ���
    4>���Թ���ѡ����������Ԫ�ؼ��ϣ�
    1��[attribute]
    ʾ����$("p[id]") ѡȡӵ��id���Ե�pԪ��
    2��[attribute=value]
    ʾ����$("input[name=text]") ѡȡӵ��name���Ե���text��inputԪ��
    3��[attribute!=value]
    ʾ����$("input[name!=text]") ѡȡӵ��name���Բ�����text��inputԪ��
    4��[attribute^=value]
    ʾ����$("input[name^=text]") ѡȡӵ��name������text��ʼ��inputԪ��
    5��[attribute$=value]
    ʾ����$("input[name$=text]") ѡȡӵ��name������text������inputԪ��
    6��[attribute*=value]
    ʾ����$("input[name*=text]") ѡȡӵ��name���Ժ���text��inputԪ��
    7��[attribute~=value]
    ʾ����$("input[class~=text]") ѡȡӵ��class�����Կո�ָ��ֵ�к���text��inputԪ��
    8��[attribute1][attribute2][attributeN]
    �������ϲ�������Թ���ѡ����
    5>�����������Թ���ѡ����������Ԫ�ؼ��ϣ�
    1��:enabled
    ������ѡȡ���п���Ԫ��
    2��:disabled
    ������ѡȡ���в�����Ԫ��
    3��:checked
    ������ѡȡ���б�ѡ�е�Ԫ�أ���ѡ�򣬸�ѡ��
    ʾ����$("input:checked") ѡȡ���б�ѡ�е�<input>Ԫ��
    4��:selected
    ������ѡȡ���б�ѡ�е�ѡ��Ԫ�أ������б���
    ʾ����$("select option:selected") ѡȡ���б�ѡ�е�ѡ��Ԫ��
    �ġ�����ѡ����������Ԫ�ؼ��ϣ�ʹ�����ƣ�
    1��:text
    ������ѡ�����еĵ����ı���
    ʾ����$(":text")ѡȡ���еĵ����ı���
    2��:password
    ������ѡ�����е������
    3��:button
    ������ѡ�����еİ�ť
    4��:checkbox
    ������ѡ�����еĶ�ѡ��
  


5.Dom�������תjquery����jquery�������תDom���� 
    dom -> jquery
    $(document.getElementById("jquery"))

	jquery -> dom
	    1.$("#jquery").get(0);
	    2.$("#jquery")[0]; $("div")[5];
	
6.���ַ�ʽ����Ч��document.getElementbyId("myId") ���� $("#myId")��
    ��һ�֣���Ϊ��ֱ��ʹ��javascript����
  
7.��Ҫ������ϰѡ����
 

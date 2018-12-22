# 开发记录
* 消费行为几个特征值统计方法.
* Django后台部署
* 排行榜billing计算方法
* 商品品牌统计: 商品购买量(排序)
# 知识记录
BigDecimal类:
* float和double 没有提供精确的结果
* BigDecimal可以提供精确的结果
1. 构造方法
new BigDecimal(val) # int/double/String val
* double类型转换
BigDecimal.valueOf()
或者
new BigDecimal(Double.toString(double))
2. 四则运算
* divide(BigDecimal divisor,int scale,int roundingMode) 
param1:除数
param2:小数保留位数
param3:舍入格式
# 消费行为分析计算方式
特征值: 
A 比零系数(反应消费均衡的系数[0,1],0.5最佳):[0,1]
* M=|R-L|/S, B=M+0.5(M<0.5) B=M-0.5(M>=0.5)
* M:间接比零系数 L:餐饮(饮食)+服饰+学习支出和 R:其余消费和 S:总消费量 
* B:M映射后的比零系数
B 大金额商品占比(超过200元以上的商品的统计和占总商品和)[0,1] 0.2
* P/S
* P: 支出中超过200元商品的总计, S:总消费量
C 商品购买率:(>=3次购买作为重复购买，重复购买商品数/全部购买的商品数) [0,1] 0.3
* D/C
* D:购买同分类商品的平均购买次数 C:全部购买的商品数
D 消费波动率:每个月之间的波动值的平均值-群体月波动均值的最小值/群体月波动均值的范围 [0,1] 0.2
* (avg-min)/(max-min)
* max:本人最大月波动值 min:本人最小月波动值  avg:平均月波动值  
E 经济率:[0,1] 0.9-1
* N/S
* N: 支出中低于50元商品的总计, S:总消费量
F 常用种类占比 [0,1] 0.8 -1
* (A+B+C)/S
* A:餐饮消费总量 B:服饰消费总量 C:学习消费总量 S:总消费量
# 比零评分
影响因素
6个特征值权重不同
A: 100- |A-0.5| * 100
B: 100- |B-0.2| * 100
C: 100- |C-0.3| * 100
D: 100- |D-0.2| * 100
E: 100- |E-0.95|* 100
F: 100- |F-0.9| * 100
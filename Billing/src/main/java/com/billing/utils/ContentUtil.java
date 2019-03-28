package com.billing.utils;

/**
 * @author sunLei on 2019/3/24 12:34
 * @version 1.0
 * @apiNote
 */
public enum  ContentUtil {
    INSTANCE;
    /**获取行为描述信息:[value]行为占比值[flag]标记类别如理性型*/
    //flag=1:理智型,2:冲动型,3:随机型 4:习惯型 5:经济型 6:专注型
    public String getActionInfo(String value,int flag){
        double d=Double.valueOf(value.substring(0,value.length()-2))/100.0;
        System.out.println(d);
        if(d>=0 && d<0.2){
            switch (flag){
                case 1:
                    return "炫耀性消费等非理智消费现象严重，重视娱乐性、消遣性消费,忽视智力性、发展性消费";
                case 2:
                    return "非常符合冷静消费类型，并理性对待广告、促销等环境因素";
                case 3:
                    return "非常符合计划性消费类型，并存在重复购买商品的现象";
                case 4:
                    return "易受新颖商品吸引，几乎不存在针对性重复消费";
                case 5:
                    return "奢侈消费现象严重，过于重视娱乐性消费，缺乏理财意识";
                case 6:
                    return "基本都属于常规消费，消费多样化";
                    default:
                        return "未定义";

            }
        }else if (d>=0.2 && d<0.4){
            switch (flag){
                case 1:
                    return "消费不均衡，存在多次大额不必要消费现象";
                case 2:
                    return "消费波动较小，但是曾在部分类别上进行大额消费";
                case 3:
                    return "消费波动较小，但存在针对多个类别上进行突发性消费的现象";
                case 4:
                    return "偶尔存在重复消费现象，但几乎只限于低价消费";
                case 5:
                    return "经常进行大额商品消费，有一定理财意识但很难自主进行实践";
                case 6:
                    return "经常进行大额商品消费，有一定理财意识但很难自主进行实践";
                default:
                    return "未定义";
            }
        }else if (d>=0.4 && d<0.6){
            switch (flag){
                case 1:
                    return "消费较理性，但是易受节日促销、销售宣传等营销策略影响";
                case 2:
                    return "消费存在一定波动情况，存在高偏向性或在特定时间段进行的针对性消费";
                case 3:
                    return "消费存在一定随机性，可受外界因素影响进行突发性消费";
                case 4:
                    return "存在重复消费现象，属于正常水平";
                case 5:
                    return "有一定理财意识，在日常用品等低价商品方面仍缺乏择优而购的实践";
                case 6:
                    return "存在对日常用品的针对性消费情况，消费有一定的多样性";
                default:
                    return "未定义";
            }
        }else if(d>=0.6 && d<0.8){
            switch (flag){
                case 1:
                    return "基本属于理性消费，但是偶尔会进行消遣性消费";
                case 2:
                    return "消费波动较大，存在多次大额消费或指定商品的突发消费";
                case 3:
                    return "消费随机性较大，易受较多因素影响进行大量不定向消费";
                case 4:
                    return "存在较多的重复消费现象，对指定商品的定向消费较多";
                case 5:
                    return "基本属于经济消费，针对物美价廉的商品进行购买";
                case 6:
                    return "多为常用商品消费，消费缺乏多样性";
                default:
                    return "未定义";
            }
        }else{
            switch (flag){
                case 1:
                    return "属于理智型消费，提倡坚持。";
                case 2:
                    return "属于冲动型消费，注意减少强制推销消费，消费前可考虑商品的实用与功能性、价格是否实惠、是否急需购买等。";
                case 3:
                    return "属于随机型消费，注意减少不必要的开销，并尝试制定购买计划，并常比较同类产品的品质以及价格的合理性。";
                case 4:
                    return "属于习惯型消费，注意经常购买商品的价格变动，以及比对同类商品的性价比，由此选择更优质的商品。";
                case 5:
                    return "属于经济型消费，过于看重商品价格是否低廉，注意考证所购买物品的实际价值，多参考其他人的购买经历，从而避免购买前后存在的商品质量的差异。";
                case 6:
                    return "属于专注性消费，基本只在常用种类上进行消费，严重缺乏消费的多样性";
                default:
                    return "未定义";
            }
        }
    }
}

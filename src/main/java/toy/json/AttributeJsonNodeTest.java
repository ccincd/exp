package toy.json;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.node.TextNode;

/**
 * AttributeJsonNodeTest
 *
 * @author chi.chen
 * @date 16-3-8
 * @time 下午4:38
 */
public class AttributeJsonNodeTest {

    public static void main(String[] args) {
        String str = "{\n" + "    \"version\": \"3\",\n" + "    \"packageType\": \"6\",\n"
                + "    \"categoryTreeCode\": \"1058#1081#1082\",\n" + "    \"categoryText\": \"休闲养生-溜溜球\",\n" + "\n"
                + "    \"basicInfo\": {\n" + "        \"contractId\": \"1728955\",\n"
                + "        \"merchantName\": \"姚记养生店\",\n" + "        \"packageSerial\": \"PKG09000987\",\n"
                + "        \"packageName\": \"超值休闲养生套餐\",\n" + "        \"signDate\": \"\",\n"
                + "        \"relativeStores\": [\n" + "        ],\n" + "        \"appointPhones\": [\n"
                + "                \"01022222222\",                \"01087878787\"            ],\n"
                + "        \"editTypeCode\":  0 ,\n" + "        \"service\": {\n" + "            \"price\": 123,\n"
                + "            \"groupPrice\": 120,\n" + "            \"settlePrice\": 110,\n"
                + "            \"selectOption\": {\n" + "                \"total\": 10,\n"
                + "                \"selectable\": 2\n" + "            },\n" + "            \"combos\": [\n"
                + "                {\n" + "                    \"categories\": [\n" + "                        {\n"
                + "                            \"items\": [\n" + "                                    {\n"
                + "                                    \"name\": \"溜溜球单卖\",\n"
                + "                                    \"spec\": \"123\",\n"
                + "                                            \"price\": 5,\n"
                + "                                                    \"timeLimit\": {\n"
                + "                                        \"type\": \"1\",\n"
                + "                                        \"minute\": \"120\"\n"
                + "                                    }\n"
                + "                                        }                                ]\n"
                + "                        }\n" + "                    ]\n" + "                }\n" + "            ]\n"
                + "        },\n" + "        \"restrictionRules\": \"限制条款\"\n" + "    },\n" + "\n"
                + "    \"purchaseNotice\": {\n" + "        \"transactionType\": 1,\n" + "        \"validDate\": {\n"
                + "            \"startDate\": \"2016-03-08\",\n" + "            \"endDate\": \"2016-03-08\"\n"
                + "        },\n" + "        \"dateLimit\": {\n" + "            \"type\": \"noLimit\"\n"
                + "            ,\n" + "            \"limitVal\": {\n" + "                \"weekList\": [\n"
                + "                                ],\n" + "                \"exactDateList\": [\n"
                + "                                ],\n" + "                \"sectionDateList\": [\n"
                + "                                ],\n" + "                \"legalHoliday\": \"\"\n"
                + "            }\n" + "        },\n" + "        \"timeLimit\":{\n"
                + "            \"type\": \"limit\",\n" + "            \"limitTime\": [\n" + "            ]\n"
                + "        },\n" + "        \"appointment\": {\n" + "            \"type\": \"2\",\n"
                + "            \"leastVal\": \"1\",\n" + "            \"leastUnit\": \"1\",\n"
                + "            \"mostVal\": \"2\",\n" + "            \"mostUnit\": \"1\"\n" + "        },\n"
                + "        \"highestCount\": {\n" + "            \"type\": 2,\n" + "            \"count\": \"\"\n"
                + "        },\n" + "        \"limitBuyCount\": {\n" + "            \"type\": 2,\n"
                + "            \"count\": \"\"\n" + "        },\n" + "        \"selLimitVolumeNum\": {\n"
                + "            \"type\": 2,\n" + "            \"count\": \"\"\n" + "        },\n"
                + "        \"limitUserCount\": {\n" + "            \"type\": 2,\n" + "            \"count\": \"\"\n"
                + "        },\n" + "       \"limitHotelGuest\": \"true\"\n" + "    },\n" + "\n"
                + "    \"packageDescription\": {\n" + "        \"images\": [\n" + "                {\n"
                + "                \"id\": \"9691411\",\n"
                + "                \"previewUrl\": \"http://userimg.qunar.com/imgs/201508/25/66I5P25VwgnRRfau6normal.jpg\",\n"
                + "                \"downloadUrl\": \"http://userimg.qunar.com/imgs/201508/25/66I5P25VwgnRRfau6normal.jpg\",\n"
                + "                \"displayUrl\": \"http://userimg.qunar.com/imgs/201508/25/66I5P25VwgnRRfau6normal.jpg\",\n"
                + "                        \"tag\": 0,\n" + "                \"type\": \"环境\",\n"
                + "                \"sourceText\": \"酒店老板\",\n"
                + "                \"merchantSerial\": \"CH01098378\",\n" + "                \"imageId\": \"\"\n"
                + "            },                {\n" + "                \"id\": \"9691412\",\n"
                + "                \"previewUrl\": \"http://userimg.qunar.com/imgs/201508/25/66I5P25Vwg0hXe-86normal.jpg\",\n"
                + "                \"downloadUrl\": \"http://userimg.qunar.com/imgs/201508/25/66I5P25Vwg0hXe-86normal.jpg\",\n"
                + "                \"displayUrl\": \"http://userimg.qunar.com/imgs/201508/25/66I5P25Vwg0hXe-86normal.jpg\",\n"
                + "                        \"tag\": 0,\n" + "                \"type\": \"环境\",\n"
                + "                \"sourceText\": \"酒店老板\",\n"
                + "                \"merchantSerial\": \"CH01098378\",\n" + "                \"imageId\": \"\"\n"
                + "            }            ],\n" + "        \"remark\": \"\"\n" + "    },\n" + "\n"
                + "    \"attachments\": [\n" + "            {\n" + "            \"filename\": \"\",\n"
                + "            \"previewUrl\": \"http://xxx.com/xxx.jpg\",\n"
                + "            \"downloadUrl\": \"http://xxx.abc.com/xxx.jpg\"\n" + "        }        ]\n" + "}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readTree(str);

            // "姚记养生店" 此处节点已经取到一个String，是一个TextNode，不能调用put进行更新
            TextNode textNode = (TextNode) node.get("basicInfo").get("merchantName");

            ObjectNode packNode = (ObjectNode) node.findValue("packageDescription");
            packNode.put("images", "[1, 2, 3]");

            System.out.println(textNode.toString());
            System.out.println("#####################################################");
            System.out.println(node.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package logiccodes;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 *  We suppose a set of symbols with their frequencies, given as a list of
 *  fr(S,F) terms.
 *  Example: [fr(a,45),fr(b,13),fr(c,12),fr(d,16),fr(e,9),fr(f,5)].
 *  Our objective is to construct a list hc(S,C) terms, where C is
 *  the Huffman code word for the symbol S. In our example,
 *  the result could be
 *  Hs = [hc(a,'0'), hc(b,'101'), hc(c,'100'), hc(d,'111'),
 *  hc(e,'1101'), hc(f,'1100')] [hc(a,'01'),...etc.].
 *  The task shall be performed by the predicate huffman/2 defined as follows:
 *
 * % huffman(Fs,Hs) :- Hs is the Huffman code table for the frequency table Fs
 */
public final class P44Huffman {

    private P44Huffman() {

    }

    /**
     * Calculate the Huffman code.
     *
     * @param frList input list of
     * @return Hs is the Huffman code table for the frequency table Fs
     */
    public static List<AbstractMap.SimpleEntry<String, String>> huffman(
            List<AbstractMap.SimpleEntry<String, Integer>> frList) {

        List<Node<String, Integer>> nodeList = frList
                .stream()
                .map(Node::new)
                .collect(Collectors.toList());
        while(nodeList.size()>1) {
            AbstractMap.SimpleEntry<String, Integer> min = null;
            AbstractMap.SimpleEntry<String, Integer> semin = null;
            int minPos = 0;
            int seminPos = 1;
            if (nodeList.get(0)
                    .getValue()
                    .getValue() < nodeList
                    .get(1)
                    .getValue()
                    .getValue()) {
                min = nodeList.get(0).getValue();
                semin = nodeList.get(1).getValue();
            } else {
                min = nodeList.get(1).getValue();
                semin = nodeList.get(0).getValue();
                minPos = 1;
                seminPos = 0;
            }
            for (int i = 2; i < nodeList.size(); i++)
                if (nodeList.get(i).getValue().getValue() < semin.getValue()) {
                    if (nodeList.get(i).getValue().getValue() < min.getValue()) {
                        semin = min;
                        min = nodeList.get(i).getValue();
                        seminPos = minPos;
                        minPos = i;
                    } else {
                        semin = nodeList.get(i).getValue();
                        seminPos = i;
                    }
                }
            AbstractMap.SimpleEntry<String, Integer> temp =
                    new AbstractMap.SimpleEntry<>("T",
                            min.getValue() +
                                    semin.getValue());
            Node<String, Integer> neNode = new Node<>(temp);
            neNode.setLeft(nodeList.get(minPos));
            neNode.setRight(nodeList.get(seminPos));
            if( seminPos<minPos) {
                nodeList.remove(minPos);
                nodeList.remove(seminPos);
            }else{
                nodeList.remove(seminPos);
                nodeList.remove(minPos);
            }
            nodeList.add(neNode);
        }
        return hc(nodeList.get(0));
    }

    private static List<AbstractMap.SimpleEntry<String, String>> hc(
            Node<String, Integer> treeNode) {
        List<AbstractMap.SimpleEntry<String, String>> result = new ArrayList<>();
        Queue<Node<String, Integer>> queue = new LinkedBlockingQueue();
        queue.add(treeNode);
        while(queue.size()>0){
            Node<String, Integer>  node =   queue.poll();
            if ("T".equals(node.getValue().getKey())){
                if (node.getLeft()!=null){
                    var left =  node.getLeft();
                    left.setCode(node.getCode()+"0");
                    queue.add(left);
                }

                if (node.getRight()!=null){
                    var right = node.getRight();
                    right.setCode(node.getCode()+"1");
                    queue.add(right);
                }

            }else{
                AbstractMap.SimpleEntry<String, String> re = new AbstractMap.SimpleEntry<>(
                        node.getValue().getKey(),node.getCode());
                result.add(re);
            }
        }

        return result;
    }

    private static class Node<K, V> {
        private Node left;
        private Node right;
        private AbstractMap.SimpleEntry<K, V> value;
        private String code;

        public Node() {
            this.code="";
        }

        public Node(AbstractMap.SimpleEntry<K, V> value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.code="";
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public AbstractMap.SimpleEntry<K, V> getValue() {
            return value;
        }

        public void setValue(AbstractMap.SimpleEntry<K, V> value) {
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}

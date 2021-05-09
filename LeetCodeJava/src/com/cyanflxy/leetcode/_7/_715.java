package com.cyanflxy.leetcode._7;

/**
 * @author cyanflxy
 * @since 2021.05.09
 */
public class _715 {
    static class RangeModule {
        RangeNode head;

        public RangeModule() {
            head = new RangeNode(-1, -1);
        }

        public void addRange(int left, int right) {
            RangeNode node = head;
            RangeNode last;
            while (node.next != null) {
                last = node;
                node = node.next;

                if (node.end >= left) {
                    if (left >= node.start) {
                        // left在区间内，扩展当前节点的right部分
                        node.addTo(right);
                    } else {
                        // left < node.start left在区间左侧
                        if (right < node.start) {
                            // 新增区间
                            RangeNode n = new RangeNode(left, right);
                            n.next = node;
                            last.next = n;
                        } else {
                            // 左扩区间的同时，检查并右扩区间
                            node.start = left;
                            node.addTo(right);
                        }
                    }

                    return;
                }
            }

            node.next = new RangeNode(left, right);
        }

        public boolean queryRange(int left, int right) {
            RangeNode node = head.next;
            while (node != null) {
                if (node.end > left) {
                    if (node.start <= left && right <= node.end) {
                        return true;
                    }
                    break;
                }
                node = node.next;
            }
            return false;
        }

        public void removeRange(int left, int right) {
            RangeNode node = head.next;
            RangeNode last = head;

            while (node != null) {
                if (node.end > left) {
                    if (right <= node.start) {
                        // 无交叉区间，无需删除
                        return;
                    } else if (right < node.end) {
                        if (left <= node.start) {
                            // 删除node的左半部分
                            node.start = right;
                        } else {
                            // 删除中间区域
                            RangeNode next = new RangeNode(right, node.end);
                            next.next = node.next;

                            node.end = left;
                            node.next = next;
                        }
                        return;
                    } else {// right >= node.end
                        if (left <= node.start) {
                            // 删除整个node
                            last.next = node.next;
                            node = last;
                        } else {
                            node.end = left;
                        }
                        // 可能还需要删除下一个节点的内容
                    }

                }

                last = node;
                node = node.next;
            }
        }

        static class RangeNode {
            int start;
            int end;
            RangeNode next;

            public RangeNode(int start, int end) {
                this.start = start;
                this.end = end;
            }

            public void addTo(int right) {
                if (next != null && next.start <= right) {
                    // right 侵入到了下一个区间内，则递归合并两个区间
                    end = next.end;
                    next = next.next;
                    addTo(right);
                } else if (right > end) {
                    end = right;
                }
            }

        }
    }
}

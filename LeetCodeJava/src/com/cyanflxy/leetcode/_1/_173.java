package com.cyanflxy.leetcode._1;

import com.cyanflxy.leetcode.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyanflxy
 * @since 2020/8/10
 */
public class _173 {


    class BSTIterator {

        private TreeNode root;
        private List<TreeNode> iteratorNode;

        public BSTIterator(TreeNode root) {
            this.root = root;

            iteratorNode = new ArrayList<>();
            while (root != null) {
                iteratorNode.add(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = iteratorNode.remove(iteratorNode.size() - 1);
            if (node.right != null) {
                TreeNode r = node.right;
                while (r != null) {
                    iteratorNode.add(r);
                    r = r.left;
                }
            }
            return node.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !iteratorNode.isEmpty();
        }
    }


}

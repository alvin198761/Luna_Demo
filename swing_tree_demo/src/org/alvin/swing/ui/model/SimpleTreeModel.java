/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.swing.ui.model;

import java.util.EventListener;
import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import org.alvin.swing.bean.LeafNode;
import org.alvin.swing.bean.RootNode;
import org.alvin.swing.bean.TreeNode;

/**
 *
 * @author Administrator
 */
public class SimpleTreeModel implements TreeModel {

    private TreeNode root;

    public SimpleTreeModel(TreeNode root) {
        this.root = root;
    }

    /**
     * Listeners.
     */
    protected EventListenerList listenerList = new EventListenerList();

    /**
     * Returns the root of the tree. Returns null only if the tree has no nodes.
     *
     * @return the root of the tree
     */
    public Object getRoot() {
        return root;
    }

    /**
     * Returns the index of child in parent. If either the parent or child is
     * <code>null</code>, returns -1.
     *
     * @param parent a note in the tree, obtained from this data source
     * @param child the node we are interested in
     * @return the index of the child in the parent, or -1 if either the parent
     * or the child is <code>null</code>
     */
    public int getIndexOfChild(Object parent, Object child) {
        TreeNode node = (TreeNode) parent;
        return node.children().indexOf(child);
    }

    /**
     * Returns the child of <I>parent</I> at index <I>index</I> in the parent's
     * child array.  <I>parent</I> must be a node previously obtained from this
     * data source. This should not return null if <i>index</i>
     * is a valid index for <i>parent</i> (that is <i>index</i> &gt;= 0
     * &amp;&amp;
     * <i>index</i> &lt; getChildCount(<i>parent</i>)).
     *
     * @param parent a node in the tree, obtained from this data source
     * @return the child of <I>parent</I> at index <I>index</I>
     */
    public Object getChild(Object parent, int index) {
        TreeNode node = (TreeNode) parent;
        return node.children().get(index);
    }

    /**
     * Returns the number of children of <I>parent</I>. Returns 0 if the node is
     * a leaf or if it has no children.  <I>parent</I> must be a node previously
     * obtained from this data source.
     *
     * @param parent a node in the tree, obtained from this data source
     * @return the number of children of the node <I>parent</I>
     */
    public int getChildCount(Object parent) {
        TreeNode node = (TreeNode) parent;
        return node.children().size();
    }

    /**
     * Returns whether the specified node is a leaf node. The way the test is
     * performed depends on the <code>askAllowsChildren</code> setting.
     *
     * @param node the node to check
     * @return true if the node is a leaf node
     *
     * @see #asksAllowsChildren
     * @see TreeModel#isLeaf
     */
    public boolean isLeaf(Object node) {
        return node instanceof LeafNode;
    }

    /**
     * This sets the user object of the TreeNode identified by path and posts a
     * node changed. If you use custom user objects in the TreeModel you're
     * going to need to subclass this and set the user object of the changed
     * node to something meaningful.
     */
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    /**
     * Adds a listener for the TreeModelEvent posted after the tree changes.
     *
     * @see #removeTreeModelListener
     * @param l the listener to add
     */
    public void addTreeModelListener(TreeModelListener l) {
        listenerList.add(TreeModelListener.class, l);
    }

    /**
     * Removes a listener previously added with <B>addTreeModelListener()</B>.
     *
     * @see #addTreeModelListener
     * @param l the listener to remove
     */
    public void removeTreeModelListener(TreeModelListener l) {
        listenerList.remove(TreeModelListener.class, l);
    }

    /**
     * Returns an array of all the tree model listeners registered on this
     * model.
     *
     * @return all of this model's <code>TreeModelListener</code>s or an empty
     * array if no tree model listeners are currently registered
     *
     * @see #addTreeModelListener
     * @see #removeTreeModelListener
     *
     * @since 1.4
     */
    public TreeModelListener[] getTreeModelListeners() {
        return listenerList.getListeners(TreeModelListener.class);
    }

    /**
     * Notifies all listeners that have registered interest for notification on
     * this event type. The event instance is lazily created using the
     * parameters passed into the fire method.
     *
     * @param source the source of the {@code TreeModelEvent}; typically
     * {@code this}
     * @param path the path to the parent of the nodes that changed; use
     * {@code null} to identify the root has changed
     * @param childIndices the indices of the changed elements
     * @param children the changed elements
     */
    protected void fireTreeNodesChanged(Object source, Object[] path,
            int[] childIndices,
            Object[] children) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        TreeModelEvent e = null;
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == TreeModelListener.class) {
                // Lazily create the event:
                if (e == null) {
                    e = new TreeModelEvent(source, path,
                            childIndices, children);
                }
                ((TreeModelListener) listeners[i + 1]).treeNodesChanged(e);
            }
        }
    }

    /**
     * Notifies all listeners that have registered interest for notification on
     * this event type. The event instance is lazily created using the
     * parameters passed into the fire method.
     *
     * @param source the source of the {@code TreeModelEvent}; typically
     * {@code this}
     * @param path the path to the parent the nodes were added to
     * @param childIndices the indices of the new elements
     * @param children the new elements
     */
    protected void fireTreeNodesInserted(Object source, Object[] path,
            int[] childIndices,
            Object[] children) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        TreeModelEvent e = null;
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == TreeModelListener.class) {
                // Lazily create the event:
                if (e == null) {
                    e = new TreeModelEvent(source, path,
                            childIndices, children);
                }
                ((TreeModelListener) listeners[i + 1]).treeNodesInserted(e);
            }
        }
    }

    /**
     * Notifies all listeners that have registered interest for notification on
     * this event type. The event instance is lazily created using the
     * parameters passed into the fire method.
     *
     * @param source the source of the {@code TreeModelEvent}; typically
     * {@code this}
     * @param path the path to the parent the nodes were removed from
     * @param childIndices the indices of the removed elements
     * @param children the removed elements
     */
    protected void fireTreeNodesRemoved(Object source, Object[] path,
            int[] childIndices,
            Object[] children) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        TreeModelEvent e = null;
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == TreeModelListener.class) {
                // Lazily create the event:
                if (e == null) {
                    e = new TreeModelEvent(source, path,
                            childIndices, children);
                }
                ((TreeModelListener) listeners[i + 1]).treeNodesRemoved(e);
            }
        }
    }

    /**
     * Notifies all listeners that have registered interest for notification on
     * this event type. The event instance is lazily created using the
     * parameters passed into the fire method.
     *
     * @param source the source of the {@code TreeModelEvent}; typically
     * {@code this}
     * @param path the path to the parent of the structure that has changed; use
     * {@code null} to identify the root has changed
     * @param childIndices the indices of the affected elements
     * @param children the affected elements
     */
    protected void fireTreeStructureChanged(Object source, Object[] path,
            int[] childIndices,
            Object[] children) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        TreeModelEvent e = null;
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == TreeModelListener.class) {
                // Lazily create the event:
                if (e == null) {
                    e = new TreeModelEvent(source, path,
                            childIndices, children);
                }
                ((TreeModelListener) listeners[i + 1]).treeStructureChanged(e);
            }
        }
    }

    /**
     * Notifies all listeners that have registered interest for notification on
     * this event type. The event instance is lazily created using the
     * parameters passed into the fire method.
     *
     * @param source the source of the {@code TreeModelEvent}; typically
     * {@code this}
     * @param path the path to the parent of the structure that has changed; use
     * {@code null} to identify the root has changed
     */
    private void fireTreeStructureChanged(Object source, TreePath path) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        TreeModelEvent e = null;
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == TreeModelListener.class) {
                // Lazily create the event:
                if (e == null) {
                    e = new TreeModelEvent(source, path);
                }
                ((TreeModelListener) listeners[i + 1]).treeStructureChanged(e);
            }
        }
    }

    /**
     * Returns an array of all the objects currently registered as
     * <code><em>Foo</em>Listener</code>s upon this model.
     * <code><em>Foo</em>Listener</code>s are registered using the
     * <code>add<em>Foo</em>Listener</code> method.
     *
     * <p>
     *
     * You can specify the <code>listenerType</code> argument with a class
     * literal, such as <code><em>Foo</em>Listener.class</code>. For example,
     * you can query a <code>DefaultTreeModel</code> <code>m</code> for its tree
     * model listeners with the following code:
     *
     * <pre>TreeModelListener[] tmls = (TreeModelListener[])(m.getListeners(TreeModelListener.class));</pre>
     *
     * If no such listeners exist, this method returns an empty array.
     *
     * @param listenerType the type of listeners requested; this parameter
     * should specify an interface that descends from
     * <code>java.util.EventListener</code>
     * @return an array of all objects registered as
     * <code><em>Foo</em>Listener</code>s on this component, or an empty array
     * if no such listeners have been added
     * @exception ClassCastException if <code>listenerType</code> doesn't
     * specify a class or interface that implements
     * <code>java.util.EventListener</code>
     *
     * @see #getTreeModelListeners
     *
     * @since 1.3
     */
    public <T extends EventListener> T[] getListeners(Class<T> listenerType) {
        return listenerList.getListeners(listenerType);
    }

}

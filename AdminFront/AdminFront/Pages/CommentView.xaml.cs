
using AdminFront.DTOs;
using AdminFront.Requests;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace AdminFront.Pages
{
    /// <summary>
    /// Interaction logic for CommentView.xaml
    /// </summary>
    public partial class CommentView : UserControl
    {

        private List<AdminCommentDTO> comments = new List<AdminCommentDTO>();

        private DispatcherTimer dt;
        
        public CommentView()
        {
            dt = new DispatcherTimer();
            dt.Tick += new EventHandler(AutoRefresh);
            dt.Interval = new TimeSpan(0, 5, 0);
            dt.Start();
            InitializeComponent();
            comments = ClientRequests.getComments();
            CommentList.ItemsSource = comments;
        }

        private void AutoRefresh(object sender, EventArgs args)
        {

            comments = ClientRequests.getComments();
            CommentList.ItemsSource = comments;
        }

        public void approveComment(object sender, RoutedEventArgs args)
        {
            if(CommentList.SelectedItem == null)
            {
                MessageBox.Show("Please select a comment to approve");
                return;
            }
            ClientRequests.ApproveComment(comments.ElementAt(CommentList.SelectedIndex));
            comments = ClientRequests.getComments();
            CommentList.ItemsSource = comments;
        }

        private void banComment(object sender, RoutedEventArgs e)
        {
            if (CommentList.SelectedItem == null)
            {
                MessageBox.Show("Please select a comment to decline");
                return;
            }
            ClientRequests.BanComment(comments.ElementAt(CommentList.SelectedIndex));
            comments = ClientRequests.getComments();
            CommentList.ItemsSource = comments;
        }
    }
}
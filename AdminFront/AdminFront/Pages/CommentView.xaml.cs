<<<<<<< HEAD
﻿using AdminFront.DTOs;
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

namespace AdminFront.Pages
{
    /// <summary>
    /// Interaction logic for CommentView.xaml
    /// </summary>
    public partial class CommentView : UserControl
    {

        List<AdminCommentDTO> comments = new List<AdminCommentDTO>();




        public CommentView()
        {
            InitializeComponent();
            comments = ClientRequests.getComments();
            //if (comments.Count==0)
            //{
            //    comments.Add(new AdminCommentDTO(0,"nocomments","nocomments"));
            //}
            CommentList.ItemsSource = comments;
        }

        public void approveComment(object sender, RoutedEventArgs args)
        {

            ClientRequests.ApproveComment(comments.ElementAt(CommentList.SelectedIndex));
            comments = ClientRequests.getComments();
            CommentList.ItemsSource = comments;
        }

        private void banComment(object sender, RoutedEventArgs e)
        {

            ClientRequests.BanComment(comments.ElementAt(CommentList.SelectedIndex));
            comments = ClientRequests.getComments();
            CommentList.ItemsSource = comments;
        }

=======
﻿using System;
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

namespace AdminFront.Pages
{
    /// <summary>
    /// Interaction logic for CommentView.xaml
    /// </summary>
    public partial class CommentView : UserControl
    {
        public CommentView()
        {
            InitializeComponent();
        }
>>>>>>> branch 'master' of https://github.com/borishadzic/XWS-Project.git
    }
}
